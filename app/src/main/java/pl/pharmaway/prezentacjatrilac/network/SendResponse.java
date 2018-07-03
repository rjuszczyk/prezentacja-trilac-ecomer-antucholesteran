package pl.pharmaway.prezentacjatrilac.network;

import android.support.annotation.Nullable;

public class SendResponse {
    int status;
    @Nullable
    String error;

    public boolean isSuccess() {
        return status == 1;
    }
}
