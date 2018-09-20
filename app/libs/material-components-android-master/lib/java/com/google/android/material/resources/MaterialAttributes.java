/*
 * Copyright (C) 2018 The Android Open Source Project
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
package com.google.android.material.resources;

import static android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.RestrictTo;
import android.util.TypedValue;
import android.view.View;

/**
 * Utility methods to work with attributes.
 *
 * @hide
 */
@RestrictTo(LIBRARY_GROUP)
public class MaterialAttributes {

  public static TypedValue resolveAttributeOrThrow(
      View componentView, @AttrRes int attributeResId) {
    TypedValue typedValue = new TypedValue();
    Context context = componentView.getContext();
    if (!context.getTheme().resolveAttribute(attributeResId, typedValue, true)) {
      String errorMessage =
          "The %1$s view requires a value for the %2$s attribute to be set in your app theme. "
              + "You can either set the attribute in your theme or "
              + "update your theme to inherit from Theme.MaterialComponents (or a descendant).";
      throw new IllegalArgumentException(
          String.format(
              errorMessage,
              componentView.getClass().getCanonicalName(),
              context.getResources().getResourceName(attributeResId)));
    }
    return typedValue;
  }
}
