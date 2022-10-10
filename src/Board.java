public class Board {

    private Field[] fields = new Field[40];

    Board(String[] data){
        createFields(data);
    }

    private Field[] createFields(String[] data){
        for(int i = 0; i < fields.length; i++){
            String s = data[i];
            String[] values = s.split(",");
            /*TODO: Instantiate subclasses of Field based on data. (No field is just a field)
               1. add a switch-case that looks at the type of the field to be created
               2. create the subclasses need to instiate based on the type of field. (constructor, attributes and override onString and onLand methods)
            *
            *  PSEUDO CODE:
            *
            *  Field f = null;
            *  switch(values[1])
            *  case "plot": f = new Plot(...)
            *
            */

            int id =  Integer.parseInt(values[0]);
            String fieldtype = values[1];
            String label = values[2];
            int cost = Integer.parseInt(values[3]);
            int income = Integer.parseInt(values[4]);
            int seriesID = Integer.parseInt(values[5]);

            Field f;

            switch (fieldtype) {
                case "plot": f = new Plot(id, label, cost, income, seriesID);

                break;
                case "lykkefelt": f = new Chance(id, label,cost, income);

                    break;
                default: f = new Field(id, label, cost, income);
            }




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