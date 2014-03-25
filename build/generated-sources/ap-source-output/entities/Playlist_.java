package entities;

import entities.AppUser;
import entities.Music;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-03-21T11:47:58")
@StaticMetamodel(Playlist.class)
public class Playlist_ { 

    public static volatile SingularAttribute<Playlist, Integer> id;
    public static volatile ListAttribute<Playlist, Music> musics;
    public static volatile SingularAttribute<Playlist, Date> creationDate;
    public static volatile SingularAttribute<Playlist, String> name;
    public static volatile SingularAttribute<Playlist, AppUser> user;
    public static volatile SingularAttribute<Playlist, Integer> size;

}