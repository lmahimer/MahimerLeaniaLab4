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

package com.google.android.material.radiobutton;

import com.google.android.material.R;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.annotation.Nullable;
import com.google.android.material.color.MaterialColors;
import android.support.v4.widget.CompoundButtonCompat;
import android.support.v7.widget.AppCompatRadioButton;
import android.util.AttributeSet;

/**
 * A class that creates a Material Themed RadioButton.
 *
 * <p>This class uses attributes from the Material Theme to style a RadioButton. Excepting color
 * changes, it behaves identically to {@link AppCompatRadioButton}. Your theme's {@code
 * ?attr/colorSecondary}, {@code ?attr/colorSurface}, and {@code ?attr/colorOnSurface} must be set.
 */
public class MaterialRadioButton extends AppCompatRadioButton {

  private final int[][] enabledCheckedStates =
      new int[][] {
        new int[] {android.R.attr.state_enabled, android.R.attr.state_checked}, // [0]
        new int[] {android.R.attr.state_enabled, -android.R.attr.state_checked}, // [1]
        new int[] {-android.R.attr.state_enabled, android.R.attr.state_checked}, // [2]
        new int[] {-android.R.attr.state_enabled, -android.R.attr.state_checked} // [3]
      };

  public MaterialRadioButton(Context context) {
    this(context, null);
  }

  public MaterialRadioButton(Context context, @Nullable AttributeSet attrs) {
    this(context, attrs, R.attr.radioButtonStyle);
  }

  public MaterialRadioButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    if (CompoundButtonCompat.getButtonTintList(this) == null) {
      setColorThemedButtonTintList();
    }
  }

  private void setColorThemedButtonTintList() {
    int colorSecondary = MaterialColors.getColor(this, R.attr.colorSecondary);
    int colorOnSurface = MaterialColors.getColor(this, R.attr.colorOnSurface);
    int colorSurface = MaterialColors.getColor(this, R.attr.colorSurface);

    int[] radioButtonColorList = new int[enabledCheckedStates.length];
    radioButtonColorList[0] =
        MaterialColors.layer(colorSurface, colorSecondary, MaterialColors.ALPHA_FULL);
    radioButtonColorList[1] =
        MaterialColors.layer(colorSurface, colorOnSurface, MaterialColors.ALPHA_MEDIUM);
    radioButtonColorList[2] =
        MaterialColors.layer(colorSurface, colorOnSurface, MaterialColors.ALPHA_DISABLED);
    radioButtonColorList[3] =
        MaterialColors.layer(colorSurface, colorOnSurface, MaterialColors.ALPHA_DISABLED);
    CompoundButtonCompat.setButtonTintList(
        this, new ColorStateList(enabledCheckedStates, radioButtonColorList));
  }
}
