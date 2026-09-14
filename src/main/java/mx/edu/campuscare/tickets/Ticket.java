package mx.edu.campuscare.tickets;
import jakarta.persistence.*;
@Entity public class Ticket {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 private String owner; private String title; @Column(length=4000) private String description; private String status="OPEN"; private boolean privateNote;
 protected Ticket(){} public Ticket(String owner,String title,String description,boolean privateNote){this.owner=owner;this.title=title;this.description=description;this.privateNote=privateNote;}
 public Long getId(){return id;} public String getOwner(){return owner;} public void setOwner(String v){owner=v;} public String getTitle(){return title;} public void setTitle(String v){title=v;} public String getDescription(){return description;} public void setDescription(String v){description=v;} public String getStatus(){return status;} public void setStatus(String v){status=v;} public boolean isPrivateNote(){return privateNote;} public void setPrivateNote(boolean v){privateNote=v;}
}
