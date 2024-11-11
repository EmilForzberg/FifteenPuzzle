package inlämningsuppgifter.uppgift3.fifteenPuzzleV3Classes;

// GameLogic-klassen innehåller spelmetoder och logiken i spelet.
class GameLogic {

    private final GameGrid gameGrid;

    // Konstruktor för att koppla ihop GameLogic och GameGrid.
    public GameLogic(GameGrid gameGrid) {
        this.gameGrid = gameGrid;
    }

    // Metod som kontrollerar om två positioner är intill varandra.
    public static boolean isAdjacent(int index1, int index2) {

        /**     Antal positioner 1-16, sedan bildas ett 4x4-rutnät
         *      index1 / 4 : ger raden där brickan ligger
         *      index2 % 4 : ger kolumnen där brickan ligger
         *
         *      T.ex. Jag vill kolla om brickorna på positionerna 5 och 6 ligger bredvid varandra.
         *      (Eftersom jag matar in en int kommer den endast ge mig heltal utan decimaler)
         *      (Jag börjar också räkna från 0, så rad 1 är "0", rad 2 är "1", och så vidare)
         *
         *      Position "5": ligger på rad 1, kolumn 1.
         *      Rad: 5 / 4 = 1
         *      Kolumn: 5 % 4 = 1
         *
         *      Position "6": ligger på rad 1, kolumn 2.
         *      Rad: 6 / 4 = 1
         *      Kolumn: 6 % = 2
         */

        int row1 = index1 / 4, column1 = index1 % 4;
        int row2 = index2 / 4, column2 = index2 % 4;


        /**     Första delen av uttrycket kontrollerar om två brickor ligger intill varandra VERTIKALT
         *
         *      Genom att subtrahera "row2 från row1" får jag avståndet mellan de två raderna
         *      Om resultatet blir exakt 1 ligger brickorna precis en rad ifrån varandra
         *
         *      (Metoden "Math.abs" tar absolutvärdet av skillnaden.
         *      Jag är endast intresserade av avståndet, INTE vilken av raderna som är högre eller lägre).
         *
         *      column1 == column2: Säkerställer att båda brickorna är i samma kolumn.
         *      Detta innebär att brickorna är i SAMMA kolumn men på OLIKA rader
         *
         *      ----------------------------------------------------------------------------------
         *
         *      Andra delen av uttrycket kontrollerar om två brickor ligger intill varandra HORISONTELLT
         *
         *      Genom att subtrahera "column2 från column1" får jag avståndet mellan de två kolumnerna
         *      Om resultatet blir exakt 1 ligger brickorna precis en kolumn ifrån varandra
         *
         *      (Math.abs tar absolutvärdet här också, eftersom jag endast bryr mig om avståndet mellan kolumnerna).
         *
         *      row1 == row2: Säkerställer att båda brickorna är på samma rad.
         *      Detta innebär att brickorna är på SAMMA rad men i OLIKA kolumner.
         *
         */

        return (Math.abs(row1 - row2) == 1 && column1 == column2)
                // Returnerar true om brickorna är intill varandra vertikalt

                || // ELLER. Om något av uttrycken stämmer blir det "true".

                (Math.abs(column1 - column2) == 1 && row1 == row2);
                // Returnerar true om brickorna är intill varandra horisontellt
    }
}