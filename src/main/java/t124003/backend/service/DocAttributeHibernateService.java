package t124003.backend.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.metamodel.relational.Datatype;
import org.springframework.stereotype.Service;
import t124003.backend.model.AtrTypeSelectionValue;
import t124003.backend.model.DataType;
import t124003.backend.model.DocAttribute;
import t124003.backend.model.DocAttributeType;

import javax.smartcardio.ATR;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by Raviool on 21.05.2015.
 */
@Service("docAttributeService")
public class DocAttributeHibernateService {

    public DocAttributeHibernateService() {};

    public List<DocAttribute> findDocumentAttributes(int id) {
        List <DocAttribute> docAttributes = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("FROM DocAttribute  as da WHERE da.documentFk=:id ORDER BY orderby");
            q.setInteger("id", id);
            docAttributes = q.list();
        } finally {
            session.close();
        }
        return docAttributes;
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

    public List<AtrTypeSelectionValue> findSelectionAttributeValues(DocAttribute attribute) {
        DataType type = findAttributeDataType(attribute);
        int atrType = attribute.getDocAttributeTypeFk();
        List<AtrTypeSelectionValue> attributeSelections = null;
        if (type.getTypeName().equals("valik nimekirjast")) {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            try {
                session.beginTransaction();
                Query q = session.createQuery("FROM AtrTypeSelectionValue  as atsv WHERE atsv.docAttributeTypeFk=:atrType ORDER BY orderby");
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
}
