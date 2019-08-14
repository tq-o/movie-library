
/* This class encapsulates a list of movies in a user's collection.
 * The list is implemented as an array of type Movie. 
 * Each movie is represented by an instance of the Movie class.
*/
public class MovieList {
   //Class member variable declarations:
   
        // TODO: Put your declarations here.
   private Movie movieList[];
   private int numMovies;
   private int initialLength;


   /* Constructor that initializes the member variables. The array is 
   *  created using the initial length passed in to the constructor.
   *  The initialLength is assigned to the initial length passed in to the constructor.
   *  The numMovies is initialized to 0.
   *  Any other member variables are initialized as well.
   */    
   public MovieList(int initialLen){
       // TODO: Implement this method.
       movieList = new Movie[initialLen];
       initialLength = initialLen; 
       numMovies = 0;
   }
   
   /* Add the newMovie passed in to the next available cell in the movieList.
    * Available (empty) cells have the value NULL. The numMovies variable may be used
    * to keep track of the index of the next available cell.
    * For example, if the list contained: item1, item2, NULL, NULL,
    * the next available cell is at index 2.
   */
   public void addMovie(Movie newMovie){
       // TODO: Implement this method.
       
       movieList [numMovies] = newMovie;
       numMovies += 1; 
       if (isFull()) movieList = expandList(movieList);
       
       
   }

  /* This method returns an array that contains only Movie objects whose 
   * title matches the targetTitle passed in.
   * The array returned does not contain any NULL values.
   * This method returns an array of length 0 if there are no matches.
   * This method may call the getOnlyItems method.
   */   
   public Movie[] findMoviesByTitle(String targetTitle) {
       // TODO: Implement this method.
       Movie[] newMovie = new Movie[1];
       int j = 1;
       
        Movie[] newMovieList = getMovieListAsArray();
        for (int i = 0; i< newMovieList.length ; i ++){
             
             if ((newMovieList[i].getTitle()).equals(targetTitle)) {
                  
                  newMovie = expandList(newMovie); 
                     
                  newMovie[j-1] = newMovieList [i];
                  //newMovie = getOnlyItems(newMovie,j);  
                  j++;
                  
              }
                 
             }   
             newMovie = getOnlyItems(newMovie,j-1);
             if (j==1)
              newMovie = new Movie[0];
        
       return newMovie;
   }
   
  /* This method returns an array that contains only Movie objects whose 
   * genre matches the targetGenre passed in.
   * The array returned does not contain any NULL values.
   * This method returns an array of length 0 if there are no matches.
   * This method may call the getOnlyItems method.
   */   
   public Movie[] findMoviesByGenre(String targetGenre) {
      // TODO: Implement this method.
       
        Movie[] newMovie = new Movie[1];
        int j = 1;
        Movie[] newMovieList = getMovieListAsArray();
        for (int i = 0; i< newMovieList.length ; i ++){
             
             if ((newMovieList[i].getGenre()).equals(targetGenre)) {
                  
                  newMovie = expandList(newMovie); 
                     
                  newMovie[j-1] = newMovieList [i];
                  newMovie = getOnlyItems(newMovie,j);
                  j++;
                  
              }   
          }     
             if (j==1)
               newMovie = new Movie[0];
               
        
       return newMovie;
   }
   
  
   
   
  /* This method returns an array of all of the Movie objects that are 
   * stored in the movieList. The array returned does not contain any NULL 
   * values. This method returns an array of length 0 if the movieList is empty.
   * This method may call the getOnlyItems method
   */
   public Movie[] getMovieListAsArray(){
   // TODO: Implement this method.
      return getOnlyItems(movieList, numMovies);
   }
    
    /* Returns the number of Movies stored in the movieList. 
    */
    public int getNumMovies(){
    // TODO: Implement this method.
        return numMovies;
    }
    
   /* Returns true if the movieList contains no Movies, false otherwise.
    */
   public boolean isEmpty(){
   // TODO: Implement this method.
      
      if (movieList[0]  == null) 
         return true;
      else 
         return false;
   }
  
    /****** Private, "helper" method section ******/
   
   /* Creates a new array that is double the size of the array passed in, copies the data 
    * from that array to the new array, and returns the new array. 
    * Note that the new array will contain the Movies from the previous array followed by NULL values.
    */
    private Movie[] expandList(Movie[] inputList){
      // TODO: Implement this method.
      
      Movie [] expandL = new Movie[inputList.length * 2];
      for (int i=0; i<inputList.length; i++) {
         expandL[i] = inputList[i];
      }
      return expandL;
    }
    
   /* A full Movie list is an array where all cells contain a Movie. That
    * means there is no cell that contains NULL.
    * This method returns true if all cells in the array contain a Movie
    * object, false otherwise. 
    */
    private boolean isFull(){
    // TODO: Implement this method.
     if(numMovies == movieList.length)
         return true;
      else 
         return false;
    }
    
    /*
    * This method takes an array of Movies as an input as well as
    * the number of Movies on that array. The inputArray may contain 
    * some NULL values.
    * This method returns an array that contains only the Movies in 
    * the input array and no NULL values.
    * It returns an array of length 0 if there are no Movies in the input array.
    */
    private Movie[] getOnlyItems(Movie[] inputArray, int size){
      // TODO: Implement this method.
      Movie[] inArray = new Movie[size];
      for (int i=0; i< size; i++) {
         inArray[i]=inputArray[i]; 
      }
      return inArray;    
    }
}