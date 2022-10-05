public class Board {

    private Field[] fields = new Field[40];

    Board(String[] data){
        createFields(data);
    }

    private Field[] createFields(String[] data){
        for(int i = 0; i < fields.length; i++){
            String s = data[i];
            String[] values = s.split(","); // Hvad skal vi splitte på?
            //System.out.println(i);
            //id, label, cost, income, seriesID
            Field f = new Field(Integer.parseInt(values[0]), values[2], Integer.parseInt(values[3]), Integer.parseInt(values[4]), Integer.parseInt(values[5]), null);
            fields[i] = f;
        }
        return fields;
    }
    public Field getField(int id) {
        id--;
        if (id < 0 || id >= fields.length) {
            return null;
        }
        return fields[id];
    }
}