/*
 * Copyright 2015 Ralf Eichinger.
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
package com.datazuul.iiif.presentation.api.model.other;

/**
 * The direction that canvases of the resource should be presented when rendered for the user to navigate and/or read.
 * Possible values are:
 *
 * @author Ralf Eichinger
 */
public class ViewingDirection {

    /**
     * The object is read from left to right, and is the default if not specified.
     */
    public final static String LTR = "left-to-right";

    /**
     * The object is read from right to left.
     */
    public final static String RTL = "right-to-left";

    /**
     * The object is read from the top to the bottom.
     */
    public final static String TTB = "top-to-bottom";

    /**
     * The object is read from the bottom to the top.
     */
    public final static String BTT = "bottom-to-top";
}
