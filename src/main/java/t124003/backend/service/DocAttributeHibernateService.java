package t124003.backend.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import t124003.backend.model.document.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raviool on 21.05.2015.
 */
@Service("docAttributeService")
public class DocAttributeHibernateService {

    public DocAttributeHibernateService() {};

    @SuppressWarnings("unchecked")
	public List<DocAttribute> findDocumentAttributes(int id) {
        List <DocAttribute> docAttributes = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("FROM DocAttribute as da WHERE da.documentFk=:id ORDER BY orderby");
            q.setInteger("id", id);
            docAttributes = q.list();
        } finally {
            session.close();
        }
        for (DocAttribute da: docAttributes) {
            System.out.println(da.getTypeName());
        }
        return docAttributes;
    }

    public List<DocAttributeType> findDocumentTypeAttributes(int type) {
        List <DocTypeAttribute> docTypeAttributes = null;
        List <DocAttributeType> docAttributeTypes = new ArrayList<DocAttributeType>();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("FROM DocTypeAttribute WHERE docTypeFk=:type");
            q.setInteger("type", type);
            docTypeAttributes = q.list();
            for (DocTypeAttribute dta: docTypeAttributes) {
                q = session.createQuery("FROM DocAttributeType WHERE docAttributeType=:type");
                q.setInteger("type", dta.getDocAttributeTypeFk());
                docAttributeTypes.add((DocAttributeType) q.uniqueResult());
            }

        } finally {
            session.close();
        }
        return docAttributeTypes;
    }

    public DocAttributeType findAttributeType(DocAttribute attribute) {
        DocAttributeType docAttributeType = null;
        int id = attribute.getDocAttributeTypeFk();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("FROM DocAttributeType as dat WHERE dat.docAttributeType=:id");
            q.setInteger("id", id);
            docAttributeType = (DocAttributeType) q.uniqueResult();
        } finally {
            session.close();
        }
        return docAttributeType;
    }

    public DataType findAttributeDataType(DocAttribute attribute) {
        DataType dataType = null;
        int id = attribute.getDataType();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("FROM DataType as dt WHERE dt.dataType=:id");
            q.setInteger("id", id);
            dataType = (DataType) q.uniqueResult();
        } finally {
            session.close();
        }
        return dataType;
    }

    public DataType findAttributeDataType(DocAttributeType attribute) {
        DataType dataType = null;
        int id = attribute.getDataTypeFk();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("FROM DataType as dt WHERE dt.dataType=:id");
            q.setInteger("id", id);
            dataType = (DataType) q.uniqueResult();
        } finally {
            session.close();
        }
        return dataType;
    }

    @SuppressWarnings("unchecked")
	public List<AtrTypeSelectionValue> findSelectionAttributeValues(DocAttribute attribute) {
        DataType type = findAttributeDataType(attribute);
        int atrType = attribute.getDocAttributeTypeFk();
        List<AtrTypeSelectionValue> attributeSelections = null;
        if (type.getTypeName().equals("valik nimekirjast")) {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            try {
                session.beginTransaction();
                Query q = session.createQuery("FROM AtrTypeSelectionValue as atsv WHERE atsv.docAttributeTypeFk=:atrType ORDER BY orderby");
                q.setInteger("atrType", atrType);
                attributeSelections = q.list();
            } finally {
                session.close();
            }
        } else return null;
        return attributeSelections;
    }

    public List<AtrTypeSelectionValue> findSelectionAttributeValues(DocAttributeType attribute) {
        DataType type = findAttributeDataType(attribute);
        int atrType = attribute.getDocAttributeType();
        List<AtrTypeSelectionValue> attributeSelections = null;
        if (type.getTypeName().equals("valik nimekirjast")) {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            try {
                session.beginTransaction();
                Query q = session.createQuery("FROM AtrTypeSelectionValue as atsv WHERE atsv.docAttributeTypeFk=:atrType ORDER BY orderby");
                q.setInteger("atrType", atrType);
                attributeSelections = q.list();
            } finally {
                session.close();
            }
        } else return null;
        return attributeSelections;
    }

    public AtrTypeSelectionValue findSelectedValue(DocAttribute attribute) {
        DataType type = findAttributeDataType(attribute);
        int atrType = attribute.getAtrTypeSelectionValueFk();
        AtrTypeSelectionValue selectionValue = null;
        if (type.getTypeName().equals("valik nimekirjast")) {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            try {
                session.beginTransaction();
                Query q = session.createQuery("FROM AtrTypeSelectionValue as atsv WHERE atsv.docAttributeTypeFk=:atrType");
                q.setInteger("atrType", atrType);
                selectionValue = (AtrTypeSelectionValue) q.uniqueResult();
            } finally {
                session.close();
            }
        } else return null;
        return selectionValue;
    }

    public String required(int attrType, int docType) {
        String required = "N";
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("SELECT required FROM DocTypeAttribute WHERE docAttributeTypeFk=:attr AND docTypeFk=:type");
            q.setInteger("attr", attrType);
            q.setInteger("type", docType);
            required = (String) q.uniqueResult();
        } finally {
            session.close();
        }
        return required;
    }
}
