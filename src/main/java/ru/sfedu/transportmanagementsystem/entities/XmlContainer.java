package ru.sfedu.transportmanagementsystem.entities;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

@Root(name = "XmlContainer")
public class XmlContainer<T> {
    @ElementList(inline = true, required = false)
    private List<T> collection;

    public XmlContainer() {
    }

    public XmlContainer(List<T> collection) {
        this.collection = collection;
    }

    public List<T> getCollection() {
        if (collection == null) return new ArrayList<>();
        return collection;
    }
}
