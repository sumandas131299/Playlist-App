import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Album WeekendAlbum = new Album("Weekend" , "Weekend's Album" );
        Album TravisAlbum = new Album("Travis Scott" , "Travis's Album" );

        WeekendAlbum.addsongToAlbum("starboy",4.0);
        WeekendAlbum.addsongToAlbum("Try me",3.0);
        WeekendAlbum.addsongToAlbum("Out Of Time" , 5.0);

        TravisAlbum.addsongToAlbum("Stargazing" , 3.0);
        TravisAlbum.addsongToAlbum("Wake up" , 4.0);
        TravisAlbum.addsongToAlbum("Fien" , 5.0);


        LinkedList<Song> myplaylist = new LinkedList<>();

        System.out.println(WeekendAlbum.addtoplaylistFromAblum("starboy",myplaylist));
        System.out.println(WeekendAlbum.addtoplaylistFromAlbum(2,myplaylist));
        System.out.println(WeekendAlbum.addtoplaylistFromAblum("Out Of Time",myplaylist));



        System.out.println(TravisAlbum.addtoplaylistFromAlbum(2,myplaylist));
        System.out.println(TravisAlbum.addtoplaylistFromAblum("Stargazing",myplaylist));
        System.out.println(TravisAlbum.addtoplaylistFromAblum("Fien", myplaylist));

        play(myplaylist);

    }

    private static void play(LinkedList<Song> myplaylist) {

        if(myplaylist.size()==0){
            System.out.println("your playlist is empty");
            return;
        }
        ListIterator<Song> itr = myplaylist.listIterator();
        System.out.println("Now Playing : " + itr.next());

        boolean wasnext = true;

        printmenu();
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        while (!quit){
            System.out.println("Please enter your choice");
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    printmenu();
                    break;
                case 2:
                    if(wasnext==false){
                        itr.next();
                        wasnext=true;
                    }
                    if(!itr.hasNext()){
                        System.out.println("You have reached at the end of the playlist"+itr.previous());
                        wasnext=false;

                    }
                    else {
                        System.out.println("currently playing" +itr.next());
                        wasnext=true;
                    }
                    break;
                case 3:
                    if(wasnext==true){
                        itr.previous();
                        wasnext=false;
                    }
                    if(!itr.hasPrevious()){
                        System.out.println("You have reached at the start of the playlist"+itr.next());
                        wasnext=true;

                    }
                    else {
                        System.out.println("currently playing" +itr.previous());
                        wasnext=false;
                    }
                    break;
                case 4:
                    if(wasnext==true){
                        System.out.println("Curently playing" + itr.previous());
                        wasnext=false;
                    }
                    else {
                        System.out.println("Currently Playing" + itr.next());
                        wasnext=true;
                    }
                    break;
                case 5:
                    if(wasnext==true){

                        System.out.println("Current song is removed"+itr.previous());
                        itr.remove();
                        wasnext=false;
                    }
                    else {
                        System.out.println("Current song is removed"+itr.next());
                        itr.remove();
                        wasnext=true;
                    }
                    break;
                case 6:
                    printsong(myplaylist);
                    break;
                case 7:
                    quit=true;
                    break;
                default:
                    System.out.println("wrong choice . please select again");
            }
        }
        return;
    }

    private static void printsong(LinkedList<Song> myplaylist) {
        for (Song song: myplaylist){
            System.out.println(song);
        }
        return;
    }

    private static void printmenu() {
        System.out.println("1. Show the menu again");
        System.out.println("2. Play next song");
        System.out.println("3. play previous song");
        System.out.println("4. play current song");
        System.out.println("5. Delete song from playlist");
        System.out.println("6. PLay all songs in the playlist");
        System.out.println("7. Quit application");


    }
}