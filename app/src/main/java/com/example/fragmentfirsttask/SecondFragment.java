package com.example.fragmentfirsttask;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class SecondFragment extends Fragment {
TextView textView;
    EditText reply;
    Button send2;
    String message;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(
                R.layout.fragment2, container, false);


//TOP
                if (message != null) {

            TextView message1 = (TextView) view .findViewById(R.id.text_message);
            message1.setText(message);
        }
        reply = (EditText) view.findViewById(R.id.editText_second);
        send2 = (Button) view.findViewById(R.id.button_second);
        send2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = reply.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("SendingReply", message);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                FirstFragment firstFragment = new FirstFragment();
                firstFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.framelayout, firstFragment);
                fragmentTransaction.commit();
            }
        });
        return view;
    }





//AFTER RETURN
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            message = bundle.getString("SendingMessage");
        }
    }
}



















































