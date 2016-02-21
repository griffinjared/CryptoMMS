package com.regnum.cryptomms;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

import java.util.ArrayList;

/**
 * Created by shane on 2/20/16.
 */
public class Keys extends ContentProvider {

    private ArrayList<String> privateKeys = new ArrayList<String>();
    private ArrayList<String> publicKeys = new ArrayList<String>();
    public Keys(){
        privateKeys =null;
        publicKeys=null;
    }

    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

    public String getPublic(int index){
        return publicKeys.get(index);
    }
    public void addPublic(String key){
        publicKeys.add(key);
    }
    public String getPrivate(int index){
        return privateKeys.get(index);
    }
    public void addPrivate(String key){
        privateKeys.add(key);
    }




}
