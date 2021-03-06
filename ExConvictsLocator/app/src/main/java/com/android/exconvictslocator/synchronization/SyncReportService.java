package com.android.exconvictslocator.synchronization;

import android.app.IntentService;
import android.content.Intent;
import android.os.AsyncTask;

import androidx.annotation.Nullable;

import com.android.exconvictslocator.MyDatabase;
import com.android.exconvictslocator.entities.Report;
import com.android.exconvictslocator.entities.User;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class SyncReportService extends IntentService {

    private MyDatabase myDatabase ;
    private List<Report> reports ;
    private List<User> users ;
    private  String ip = ServerIPConfig.getIp_address();

    public SyncReportService() {
        super("");
    }

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public SyncReportService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        myDatabase = MyDatabase.getDatabase(this.getApplication()) ;

        ActivityTask task1 = new ActivityTask();
        task1.execute();

    }

    private class ActivityTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            // Sinhronizacija registrovanih korisnika
            String url = "http://" + ip + ":8080/api/users/syncUsers";
            users = myDatabase.userDao().getNotSyncedUsers();

            RestTemplate restTemplate = new RestTemplate();

            try {
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                HttpHeaders headers = new HttpHeaders();
                headers.add("Content-Type", "application/json");
                HttpEntity<ArrayList<User>> entity = new HttpEntity<>((ArrayList<User>) users, headers);
                ResponseEntity<User> response = restTemplate.exchange(url, HttpMethod.POST, entity, null);
                HttpStatus status = response.getStatusCode();

                if (status == HttpStatus.OK) {
                    if (users.size() != 0) {
                        for (int i = 0; i < users.size(); i++) {
                            users.get(i).setSync(true);

                            myDatabase.userDao().update(users.get(i));
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }

            // Sinhronizacija prijavljenih reportova
            url = "http://" + ip + ":8080/api/reports/syncReports";
            reports = myDatabase.reportDao().getNotSyncedReports();

            try {
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                HttpHeaders headers = new HttpHeaders();
                headers.add("Content-Type", "application/json");
                HttpEntity<ArrayList<Report>> entity = new HttpEntity<>((ArrayList<Report>) reports, headers);
                ResponseEntity<Report> response = restTemplate.exchange(url, HttpMethod.POST, entity, null);
                HttpStatus status = response.getStatusCode();

                if (status == HttpStatus.OK) {
                    if (reports.size() != 0) {
                        for (int i = 0; i < reports.size(); i++) {
                            reports.get(i).setSync(true);

                            myDatabase.reportDao().update(reports.get(i));
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }

            return null;
        }
    }
}
