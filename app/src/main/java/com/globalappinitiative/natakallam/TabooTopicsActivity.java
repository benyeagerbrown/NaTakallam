package com.globalappinitiative.natakallam;

import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TabooTopicsActivity extends AppCompatActivity implements View.OnClickListener {

    private FloatingActionButton buttonAddTabooTopic;
    private RecyclerAdapterTaboo recyclerAdapterTaboo;
    private ArrayList<TabooTopic> tabooTopicsList = new ArrayList<>();
    private static final String EDIT = "EDIT";
    private static final String ADD = "ADD";
    private static final String DELETE = "DELETE";
    private static final String taboo_topics_url = "http://natakallam.eastus.cloudapp.azure.com/api/taboo-topics";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taboo_topics);

        setUpFab();
        setUpRecyclerView();
        getTopics();
    }

    private void setUpFab() {
        buttonAddTabooTopic = (FloatingActionButton) findViewById(R.id.buttonAddTabooTopic);
        buttonAddTabooTopic.setOnClickListener(this);
    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        recyclerAdapterTaboo = new RecyclerAdapterTaboo(tabooTopicsList);
        recyclerView.setAdapter(recyclerAdapterTaboo);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.d("Item clicked", "position " + Integer.toString(position));
                showTopicDialog(EDIT, position);
            }

            @Override
            public void onLongItemClick(View view, int position) {
                Log.d("Item pressed", "position " + Integer.toString(position));
                showTopicDialog(DELETE, position);
            }
        }));
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == buttonAddTabooTopic.getId()) {
            showTopicDialog(ADD, tabooTopicsList.size() - 1);
        }
    }

    private void getTopics() {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, taboo_topics_url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray allTabooTopics = response.getJSONArray("taboo_topics");
                    for (int i = 0; i < allTabooTopics.length(); i++) {
                        JSONObject tabooTopic = allTabooTopics.getJSONObject(i);
                        String topic = tabooTopic.getString("topic");
                        String description = tabooTopic.getString("description");
                        TabooTopic newTabooTopic = new TabooTopic(topic, description);
                        tabooTopicsList.add(newTabooTopic);
                        recyclerAdapterTaboo.notifyItemInserted(i);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    getTopicsError();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                getTopicsError();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                String token = User.getValue(User.Keys.token, getApplicationContext());
                params.put("Authorization", "Bearer " + token);
                return params;
            }
        };
        VolleySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
    }

    private void getTopicsError() {
        Toast.makeText(getApplicationContext(), getString(R.string.taboo_topics_error), Toast.LENGTH_SHORT).show();
    }

    private void addTopic(String title, String description) {
        if (title.isEmpty()) {
            showErrorDialog();
        } else {
            tabooTopicsList.add(new TabooTopic(title, description));
            recyclerAdapterTaboo.notifyItemInserted(tabooTopicsList.size() - 1);
        }
    }

    private void editTopic(String title, String description, int position) {
        if (title.isEmpty()) {
            showErrorDialog();
        } else {
            tabooTopicsList.get(position).setTopic(title);
            tabooTopicsList.get(position).setDescription(description);
            recyclerAdapterTaboo.notifyItemChanged(position);
        }
    }

    private void deleteTopic(int position) {
        tabooTopicsList.remove(position);
        recyclerAdapterTaboo.notifyItemRemoved(position);
    }

    private void showErrorDialog() {
        new android.app.AlertDialog.Builder(this)
                .setTitle(getString(R.string.empty_topic))
                .setMessage(getString(R.string.empty_topic_message))
                .setPositiveButton(getString(R.string.ok), null)
                .show();
    }

    private void showTopicDialog(final String dialogType, final int position) {
        String title;
        String positiveButton;
        switch (dialogType) {
            case EDIT:
                title = getString(R.string.edit_topic);
                positiveButton = getString(R.string.done);
                break;
            case ADD:
                title = getString(R.string.add_topic);
                positiveButton = getString(R.string.add);
                break;
            default:
                title = getString(R.string.taboo_topic_remove_confirmation);
                positiveButton = getString(R.string.remove);
                break;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.taboo_topic_edit, null);
        final EditText editTextTabooTopicTitle = (EditText) dialogView.findViewById(R.id.editTextTabooTopicTitle);
        final EditText editTextTabooTopicDescription = (EditText) dialogView.findViewById(R.id.editTextTabooTopicDescription);
        if (dialogType.equals(DELETE)) {
            dialogView = null;
        }
        builder.setView(dialogView);
        if (dialogType.equals(EDIT)) {
            editTextTabooTopicTitle.setText(tabooTopicsList.get(position).getTopic());
            editTextTabooTopicDescription.setText(tabooTopicsList.get(position).getDescription());
        }
        builder.setTitle(title);
        builder.setPositiveButton(positiveButton, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (dialogType) {
                    case EDIT:
                        editTopic(editTextTabooTopicTitle.getText().toString(), editTextTabooTopicDescription.getText().toString(), position);
                        break;
                    case ADD:
                        addTopic(editTextTabooTopicTitle.getText().toString(), editTextTabooTopicDescription.getText().toString());
                        break;
                    default:
                        deleteTopic(position);
                }
            }
        });
        builder.setNegativeButton(getString(R.string.cancel), null);
        builder.create().show();
    }
}
