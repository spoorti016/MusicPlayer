import java.util.LinkedList;
import java.util.Scanner;

public class ALbumInfo {
	Scanner sc=new Scanner(System.in);

	public void createAlbum( LinkedList<Album> albums){// method to create a new album
		System.out.println("Enter the Playlist name ");
		String albname=sc.next();

		//System.out.println("Enter the playlist Id ");
		int id=albums.getLast().getAlbumID()+1;

		// Create a new album with users data
		Album al=new Album(albname,id);
		albums.add(al);
	}

	public void displayAlbumSongs(Album al){// To display the albums
		System.out.println("Album Name :"+al.getAlbumName());
		System.out.println("Album ID   :"+al.getAlbumID());
		if(al.s!=null){//Displaying till the next is not empty**
			for(int i=0;i<al.s.size();i++){
				printSong(al.s.get(i));
			}
		}
	}

	public void diplayalbumName(LinkedList<Album> albums){
		System.out.println("AlbumID\t\tAlbumName");
		for(int i=0;i<albums.size();i++){
			System.out.println(albums.get(i).getAlbumID()+"\t\t"+albums.get(i).getAlbumName());
		}
	}

	public void printSong(Song s){// To display song in Playlist
		System.out.println("-----------------------------------------------");
		System.out.println("Name   :"+s.getSongName());
		System.out.println("Duration:"+s.getDuration());
		System.out.println("Artist  :"+s.getArtistName());
		System.out.println("Track number: "+s.getSongID());
		System.out.println("-----------------------------------------------");
	}

	public int searchalbum(int id,LinkedList<Album> albums){//To search album 
		for(int i=0;i<albums.size();i++){//Traversing the linked list
			if(id==albums.get(i).getAlbumID()){ 
				return i;
			}
		}
		return -1;
	}

	public void albumplay(LinkedList<Album> albums){//To display the Album that is playing
		do{
			System.out.println("Enter the album id that you want to play ");
			int id=sc.nextInt();
			int i=searchalbum(id,albums);
			if(i>=0){
				System.out.println("-------------------------------------------------");
				System.out.println("Playlist Name :"+albums.get(i).getAlbumName());
				System.out.println("Playlist ID   :"+albums.get(i).getAlbumID());
				System.out.println("----------------Content List-----------------------");
				for(int j=0;j<albums.get(i).s.size();j++){
					printSong(albums.get(i).s.get(j));
				}
				System.out.println("Enter the trackNumber you want to play first ");
				int trackNo=sc.nextInt();
				int ind=searchsong(albums.get(i), trackNo);
				playsong(albums.get(i),ind);
			}
			System.out.println("do you want to play something from another album press 1\nelse press 0..");
		}while (sc.nextInt()==1);
	}

	public void addSong(LinkedList<Album> albums){//To add new songs to playlist
		do{
			System.out.println("enter the album id where you want to add songs ");
			int id=sc.nextInt();
			int index=searchalbum(id,albums);
			int numberofSongs=albums.get(index).s.size();

			int cnt;
			if(numberofSongs==0) {
				cnt=1;
			}
			else {
				cnt=(albums.get(index).s.getLast().getSongID())+1;
			}
			if(index>=0){

				System.out.println("Enter the Song Name ");
				String sname=sc.next();
				System.out.println("Enter the Duration ");
				int dur=sc.nextInt();
				System.out.println("Enter the artistName ");
				String artName=sc.next();
				Song song=new Song(sname,dur,artName,cnt);
				albums.get(index).s.add(song);

				System.out.println("do you want to continue adding songs press 1\nelse press 0..");

			}
		}while (sc.nextInt()==1);
	}

	public int searchsong(Album al,int trackNo){//To search a song
		for(int i=0;i<al.s.size();i++){//Traversing
			if(trackNo==al.s.get(i).getSongID()){
				return i;
			}
		}
		return -1;
	}

	public void playsong(Album al,int index){// To show the song that is playing 
//		int index=searchsong(al,trackNo);
		if(index>=al.s.size()) {//if index is out of bounds then setting it to zero
			index=0;
		}
		else if(index<0) {
			index=al.s.indexOf(al.s.getLast());
		}

		if(index>=0){
			System.out.println();
			System.out.println("**Playing........");
			printSong(al.s.get(index));
			System.out.println("\n1.To play Previous \n2-To play next\n3-To replay the current\n4-stop playing");
			System.out.println("Enter your choice: ");
			switch (sc.nextInt()){
			case 1:{
				
				playsong(al,index-1);//Playing previous song
				break;
			}
			case 2:{
				playsong(al,index+1);//Playing next song
				break;
			}
			case 3:{
				playsong(al,index);//Playing same track again
				break;
			}
			case 4:{
				return ;
			}
			}
		}
	}

	public void deleteSong(LinkedList<Album> al) {
		int flag=0;//indicating if user has entered correct album id
		do {
			System.out.println("Enter the playlist id from which you want to delete a song");
			int id=sc.nextInt();
			int indexAlbum=searchalbum(id,al);
			if(indexAlbum!=-1) {
				flag=1;
				for(int j=0;j<al.get(indexAlbum).s.size();j++){
					printSong(al.get(indexAlbum).s.get(j));
				}
				//int numberofSongs=albums.get(index).s.size();
				System.out.println("enter the track number to be deleted");
				int trackNo=sc.nextInt();
				int index= searchsong(al.get(indexAlbum), trackNo);
				if(index!=-1) {
					al.get(indexAlbum).s.remove(index);
				}
				else {
					System.out.println("track not present");
				}
			}
			else {
				System.out.println("Enter the correct id!");

			}
		}while(flag!=1);

	}
	public void deleteAlbum(LinkedList<Album> albums) {

		System.out.println("enter the Album id to be deleted");
		int id=sc.nextInt();
		int index= searchalbum(id, albums);

		if(index!=-1) {
			albums.remove(index);
			System.out.println("Album deleted");
		}
		else {
			System.out.println("Album not present");
		}
	}
}

