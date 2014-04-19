package MTOMUpload;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.activation.DataHandler;
@XmlRootElement(name = "Customer")
@XmlAccessorType(XmlAccessType.FIELD)

public class Customer {
         private long id;
         private String name;
         @XmlMimeType("application/octet-stream")
         private DataHandler myPhoto;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public DataHandler getMyPhoto() {
			return myPhoto;
		}

		public void setMyPhoto(DataHandler myPhoto) {
			this.myPhoto = myPhoto;
		}

         

        

}