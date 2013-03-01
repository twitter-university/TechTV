/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.marakana.techtv;

import android.app.Activity;
import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

public class ContentFragment extends Fragment {
  private View mContentView;

  private String mUrl = null;
  private VideoView mVideoView = null;
  private MediaController mMC;

  // Current action mode (contextual action bar, a.k.a. CAB)
  private ActionMode mCurrentActionMode;

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    final Activity activity = getActivity();

    mContentView = inflater.inflate(R.layout.content_welcome, null);
    mVideoView = (VideoView) mContentView.findViewById(R.id.video);
    mMC = new MediaController(activity);
    mVideoView.setMediaController(mMC);
    mContentView.setDrawingCacheEnabled(false);

    // Keep the action bar visibility in sync with the system status bar. That
    // is, when entering
    // 'lights out mode,' hide the action bar, and when exiting this mode, show
    // the action bar.

    // mContentView.setOnSystemUiVisibilityChangeListener(
    // new View.OnSystemUiVisibilityChangeListener() {
    // public void onSystemUiVisibilityChange(int visibility) {
    // ActionBar actionBar = activity.getActionBar();
    // if (actionBar != null) {
    // mContentView.setSystemUiVisibility(visibility);
    // if (visibility == View.STATUS_BAR_VISIBLE) {
    // actionBar.show();
    // } else {
    // actionBar.hide();
    // }
    // }
    // }
    // });

    return mContentView;
  }

  void updateContentAndRecycleBitmap(int category, int position) {
    if (mCurrentActionMode != null) {
      mCurrentActionMode.finish();
    }

    // Get the bitmap that needs to be drawn and update the VideoView
    mUrl = Directory.getCategory(category).getEntry(position).getUrl();

    mVideoView.setVideoURI(Uri.parse(mUrl));
    mVideoView.requestFocus(); mVideoView.start(); 
    mMC.show();
  }

}
