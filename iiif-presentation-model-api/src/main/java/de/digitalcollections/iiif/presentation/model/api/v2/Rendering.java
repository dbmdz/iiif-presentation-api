package de.digitalcollections.iiif.presentation.model.api.v2;

import java.net.URI;

public interface Rendering {
    URI getId();
    
    void setId(URI id);

    String getFormat();

    void setFormat(String format);
    
    String getLabel();
    
    void setLabel(String label);
}
