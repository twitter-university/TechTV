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

public class Directory {
  private static DirectoryCategory[] mCategories;

  public static void initializeDirectory() {
    mCategories = new DirectoryCategory[] {
        new DirectoryCategory("Android", new DirectoryEntry[] {
            new DirectoryEntry("Red Balloon",
                "rtsp://rtsp2.youtube.com/v/XFRS5j3BOkw"),
            new DirectoryEntry("Green Balloon", ""),
            new DirectoryEntry("Blue Balloon", "") }),
        new DirectoryCategory("HTML5", new DirectoryEntry[] {
            new DirectoryEntry("Old school huffy", ""),
            new DirectoryEntry("New Bikes", ""),
            new DirectoryEntry("Chrome Fast", "") }),
        new DirectoryCategory("Java", new DirectoryEntry[] {
            new DirectoryEntry("Steampunk Android", ""),
            new DirectoryEntry("Stargazing Android", ""),
            new DirectoryEntry("Big Android", "") }),
        new DirectoryCategory("jQuery",
            new DirectoryEntry[] { new DirectoryEntry("Cupcake", ""),
                new DirectoryEntry("Donut", ""),
                new DirectoryEntry("Eclair", ""),
                new DirectoryEntry("Froyo", ""), }),
        new DirectoryCategory("Ruby", new DirectoryEntry[] {
            new DirectoryEntry("Steampunk Android", ""),
            new DirectoryEntry("Stargazing Android", ""),
            new DirectoryEntry("Big Android", "") }) };

  }

  public static int getCategoryCount() {
    return mCategories.length;
  }

  public static DirectoryCategory getCategory(int i) {
    return mCategories[i];
  }
}
