package de.digitalcollections.iiif.presentation.model.impl.v2;

import de.digitalcollections.iiif.presentation.model.api.v2.Rendering;

import java.net.URI;

public class RenderingImpl implements Rendering {

    protected URI id;
    protected String label;
    protected String format;

    public RenderingImpl() {
    }

    public RenderingImpl(URI id) {
        this.id = id;
    }
    
    public RenderingImpl(String id) {
        this.id = URI.create(id);
    }

    @Override
    public URI getId() {
        return id;
    }

    @Override
    public void setId(URI id) {
        this.id = id;
    }

    @Override
    public String getFormat() {
        return format;
    }

    @Override
    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
    }
}
