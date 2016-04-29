package com.app.liulongbing.beam.callBack;

import com.jude.http.RequestListener;

/**
 * Created by liulongbing on 16/4/28.
 */
public class LinkCallback implements RequestListener {

    private LinkCallback link;
    public LinkCallback add(LinkCallback other){
        other.setLink(this);
        return other;
    }
    private void setLink(LinkCallback link){
        this.link = link;
    }

    @Override
    public void onRequest() {
        if (link != null)
            link.onRequest();

    }

    @Override
    public void onSuccess(String response) {
        if (link != null)
            link.onSuccess(response);

    }

    @Override
    public void onError(String errorMsg) {
        if (link != null)
            link.onError(errorMsg);

    }
}
