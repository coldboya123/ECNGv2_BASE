package com.example.ecngv2.View.Notification;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ecngv2.Adapter.RCV_Noti_Secure_Adapter;
import com.example.ecngv2.Model.Object.NotiSecure;
import com.example.ecngv2.R;

import java.util.ArrayList;
import java.util.List;

public class NotiSecureFragment extends Fragment {

    RecyclerView recyclerView;
    List<NotiSecure> list;

    public NotiSecureFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_noti_secure, container, false);

        init(v);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(new RCV_Noti_Secure_Adapter(getContext(), list));

        return v;
    }

    private void init(View v){
        recyclerView = v.findViewById(R.id.rcv_noti_secure);

        list = new ArrayList<>();
        list.add(new NotiSecure("01/01/2021", "Bạn đã thay đổi mật khẩu thành công.....", true));
        list.add(new NotiSecure("08/03/2021", "Từ ngày 8/3 ECNG sẽ cập nhật tính năng mới cho app. Hãy cập nhật ứng dụng.....", false));
        list.add(new NotiSecure("01/01/2021", "Bạn đã thay đổi mật khẩu thành công.....", false));
    }
}