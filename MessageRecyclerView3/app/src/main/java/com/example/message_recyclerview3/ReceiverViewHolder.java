package com.example.message_recyclerview3;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ReceiverViewHolder extends RecyclerView.ViewHolder {
    private TextView tvReceiverSendMsg;

    public ReceiverViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);

    }

    private void initViews(View itemView) {
        tvReceiverSendMsg = itemView.findViewById(R.id.tvReceiverMessage);
    }

    public void setReceiveData(ReceiverModel receiverModel) {
        tvReceiverSendMsg.setText(receiverModel.getReceiverMessage());
    }
}
