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
package com.datazuul.iiif.presentation.api.model;

import java.util.List;

/**
 *
 * @author Ralf Eichinger
 */
public class Sequence {
    private String id;
    private String label;
    private final String type = "sc:Sequence";
    private String viewingDirection = "left-to-right";
    private String viewingHint = "paged";

    private List<Canvas> canvases;

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getViewingDirection() {
        return viewingDirection;
    }

    public void setViewingDirection(String viewingDirection) {
        this.viewingDirection = viewingDirection;
    }

    public String getViewingHint() {
        return viewingHint;
    }

    public void setViewingHint(String viewingHint) {
        this.viewingHint = viewingHint;
    }

    public List<Canvas> getCanvases() {
        return canvases;
    }

    public void setCanvases(List<Canvas> canvases) {
        this.canvases = canvases;
    }
    
    
}
