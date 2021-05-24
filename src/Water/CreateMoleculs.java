package Water;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreateMoleculs {

    public static String buildChain(int molecules){
        List<String> oxygen = Collections.nCopies(molecules, "O");
        List<String> hydrogen = Collections.nCopies(molecules*2, "H");
        return Stream.of(oxygen, hydrogen )
                .flatMap(Collection::stream)
                .collect(Collectors.joining());
    }
}