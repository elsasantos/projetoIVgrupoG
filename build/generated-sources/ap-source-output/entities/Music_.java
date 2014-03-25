package entities;

import entities.AppUser;
import entities.Playlist;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-03-21T11:47:58")
@StaticMetamodel(Music.class)
public class Music_ { 

    public static volatile SingularAttribute<Music, String> title;
    public static volatile SingularAttribute<Music, Integer> music_year;
    public static volatile SingularAttribute<Music, Integer> music_id;
    public static volatile SingularAttribute<Music, String> album;
    public static volatile SingularAttribute<Music, String> artist;
    public static volatile SingularAttribute<Music, String> music_path;
    public static volatile ListAttribute<Music, Playlist> playlists;
    public static volatile SingularAttribute<Music, AppUser> user;

}