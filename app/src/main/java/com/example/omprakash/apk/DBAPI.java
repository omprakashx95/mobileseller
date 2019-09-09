package com.example.omprakash.apk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;



import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DBAPI extends AppCompatActivity {

    String URL = null;
    String web="http://www.grspathfinder.com/";
    String control;
    Intent intent;
    //Activity activity= (Activity) getApplicationContext();
    Context c;

    JSONParser jsonParser = new JSONParser();
    public List<String> clouddata;

    public static boolean qr_flag=false;
    public static boolean bar_flag=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_dbapi);
    }

    public void testData(Context ct)
    {
        c=ct;
        new DataFetch(c).execute("testData","Hey Java");
    }
    public  void otp_gen(Context ct,String phone){
        c=ct;
        new DataFetch(c).execute("otp_gen",phone);

    }


    public class DataFetch extends AsyncTask<String, String, JSONObject> {

        Context ctx;
        DataFetch(Context c) {
            ctx=c;
        }

        @Override
        protected void onPreExecute() {

            super.onPreExecute();

        }

        @Override
        protected JSONObject doInBackground(String... args) {
            ArrayList params = new ArrayList();
            control=args[0];

            if(args[0].equals("otp_gen"))
            {

                URL=web+"api/new_api/common/otp_gen.php";
                params.add(new BasicNameValuePair("phonenumber", args[1]));

            }


            JSONObject json = null;


            json = jsonParser.makeHttpRequest(URL, "POST", params);


            return json;

        }


        protected void onPostExecute(JSONObject result) {

            // dismiss the dialog once product deleted
            //Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();

            try {
                if (result != null) {
                    if (control.equals("otp_gen")) {
                        String data = result.getString("msg");
                        String otp = result.getString("otp");
                       // Log.i("RESULT", data);
                        if (data.equals("SUCCESS")) {
                            Toast.makeText(ctx, "OTP Sent", Toast.LENGTH_LONG).show();
                            intent = new Intent(ctx, dashboard.class);
                            intent.putExtra("otp", otp);
                            ctx.startActivity(intent);
                            ((Activity) ctx).finish();
                        } else {
                            Toast.makeText(ctx, "Some Thing Went Wrong", Toast.LENGTH_LONG).show();
                        }
                        // Toast.makeText(ctx, data, Toast.LENGTH_LONG).show();

                    }

                }
            }

            catch (JSONException e) {
                e.printStackTrace();
            }


        }


    }
}
