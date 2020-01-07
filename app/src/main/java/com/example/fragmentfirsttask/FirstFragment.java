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

public class FirstFragment extends Fragment {
    EditText Message;
    Button send;
    String reply;
    TextView secondText;
    TextView Header;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fragment1, container, false);
    //TOP
                Message = (EditText) rootView.findViewById(R.id.editText_main);
        send = (Button) rootView.findViewById(R.id.button);
        secondText = (TextView) rootView.findViewById(R.id.text_message_reply);
        Header=(TextView)rootView.findViewById(R.id.text_header_reply);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = Message.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("SendingMessage", message);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                SecondFragment secondFragment = new SecondFragment();
                secondFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.framelayout, secondFragment);
                fragmentTransaction.commit();
            }
        });
        if (reply == null) {

            secondText.setVisibility(View.GONE);
            Header.setVisibility(View.GONE);
        } else {
            secondText.setText(reply);

        }

        return rootView;
}



//AFTER RETURN

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle != null) {
            reply = bundle.getString("SendingReply");
        }
    }


}


























//TOP



//AFTER RETURN


