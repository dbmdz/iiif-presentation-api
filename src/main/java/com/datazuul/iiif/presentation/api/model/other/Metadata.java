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
 * <p>Metadata information given as pairs of human readable label and value to be displayed to the user.
 * The value should be either simple HTML, including links and text markup, or plain text, and the label should be plain
 * text. There are no semantics conveyed by this information, and clients should not use it for discovery or other
 * purposes. This list of descriptive pairs should be able to be displayed in a tabular form in the user interface.
 * Clients should have a way to display the information about manifests and canvases, and may have a way to view the
 * information about other resources. The client should display the pairs in the order provided by the description. A
 * pair might be used to convey the author of the work, information about its creation, a brief physical description, or
 * ownership information, amongst other use cases. The client is not expected to take any action on this information
 * beyond displaying the label and value. An example pair of label and value might be a label of “Author” and a value of
 * “Jehan Froissart”.</p>
 *
 * @author Ralf Eichinger
 */
public abstract class Metadata {

    private final String label;

    public Metadata(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
