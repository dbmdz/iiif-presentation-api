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
 * A hint to the client as to the most appropriate method of displaying the resource. Other values may be given, and if
 * they are, they must be URIs.
 *
 * @author Ralf Eichinger
 */
public class ViewingHint {

    /**
     * Valid on manifest, sequence and range. Each canvas is the complete view of one side of a long scroll or roll and
     * an appropriate rendering might only display part of the canvas at any given time rather than the entire object.
     */
    public final static String CONTINUOUS = "continuous";

    /**
     * Valid on manifest, sequence and range. The canvases referenced from the resource are all individual sheets, and
     * should not be presented in a page-turning interface. Examples include a set of views of a 3 dimensional object,
     * or a set of the front sides of photographs in a collection.
     */
    public final static String INDIVIDUALS = "individuals";

    /**
     * Canvases with this hint must not be presented in a page turning interface, and must be skipped over when
     * determining the page sequence. This viewing hint must be ignored if the current sequence or manifest does not
     * have the ‘paged’ viewing hint.
     */
    public final static String NON_PAGED = "non-paged";

    /**
     * Valid on manifest, sequence and range. The canvases represent pages in a bound volume, and should be presented in
     * a page-turning interface if one is available. The first canvas is a single view (the first recto) and thus the
     * second canvas represents the back of the object in the first canvas.
     */
    public final static String PAGED = "paged";

    /**
     * Only valid on a range. A range which has this viewingHint is the top-most node in a hierarchy of ranges that
     * represents a structure to be rendered by the client to assist in navigation. For example, a table of contents
     * within a paged object, major sections of a 3d object, the textual areas within a single scroll, and so forth.
     * Other ranges that are descendants of the “top” range are the entries to be rendered in the navigation structure.
     * There may be multiple ranges marked with this hint. If so, the client should display a choice of multiple
     * structures to navigate through.
     */
    public final static String TOP = "top";
}
