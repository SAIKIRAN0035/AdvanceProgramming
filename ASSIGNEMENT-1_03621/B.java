/*Student Name: Saikiran Reddy Yarava
Course Name: Advanced Programming concepts (MCIS-5103)
Section Number: 031
Student Number:999903621*/

import java.util.Scanner;
public class B {
    public static void main(String[] args) {
        
        String dogshape = "                                         do.\n" +
                        "                                        :NOX\n" +
                        "                                       ,NOM@:\n" +
                        "                                       :NNNN:\n" +
                        "                                       :XXXON\n" +
                        "                                       :XoXXX.\n" +
                        "                                       MM;ONO:\n" +
                        "  .oob..                              :MMO;MOM\n" +
                        " dXOXYYNNb.                          ,NNMX:MXN\n" +
                        " Mo\"'  ''':Nbb                        dNMMN MNN:\n" +
                        " Mo  'O;; ':Mb.                     ,MXMNM MNX:\n" +
                        " @O :;XXMN..'X@b.                  ,NXOMXM MNX:\n" +
                        " YX;;NMMMM@M;;OM@o.                dXOOMMN:MNX:\n" +
                        " 'MOONM@@@MMN:':NONb.            ,dXONM@@MbMXX:\n" +
                        "  MOON@M@@MMMM;;:OOONb          ,MX'\"':ONMMMMX:\n" +
                        "  :NOOM@@MNNN@@X;\"\"XNN@Mb     .dP\"'   ,..OXM@N:\n" +
                        "   MOON@@MMNXXMMO  :M@@M...@o.oN\"\"\":OOOXNNXXOo:\n" +
                        "   :NOX@@@MNXXXMNo :MMMM@K\",:;NNM@@NXM@MNO;.'N.\n" +
                        "    NO:X@@MNXXX@@O:'X@@@@MOOOXMM@M@NXXN@M@NOO ''b\n" +
                        "    `MO.'NMNXXN@@N: 'XXM@NMMXXMM@M@XO\"'\"XM@X;.  :b\n" +
                        "     YNO;\":.:OXMX\"': ,:NNO;';XMMX:  ,;@@MNN.'.:O; :OX.\n" +
                        "      Y@Mb;;XNMM@@@NO: ':O: 'OXN@@MO\" ONMMX:`XO; :X@.\n" +
                        "       '@XMX':OX@@MN:    ;O;  :OX@MO\" 'OMM@N; ':OO;N@N\n" +
                        "       YN;\":.:OXMX\"': ,:NNO;';XMMX:  ,;@@MNN.'.:O;:@X:\n" +
                        "       `@N;;XOOOXO;;:O;:@MOO;:O:\"\" ,oMP@@K\"YM.;NMO;`NM\n" +
                        "        `@@MN@MOX@@MNMN;@@MNXXOO: ,d@NbMMP'd@@OX@NO;.'bb.\n" +
                        "       .odMX@@XOOM@M@@XO@MMMMMMNNbN\"YNNNXoNMNMO\"OXXNO..\"\";o.\n" +
                        "     .ddMNOO@@XOOM@@@XOONMMM@@MNXXMMo;.\"' .\":OXO ':.'\"'\"'  '\"\"o.\n" +
                        "    'N@@X;,M@MXOOM@OOON@MM@MXOO:\":ONMNXXOXX:OOO               \"\"ob.\n" +
                        "   ')@MP\"';@@XXOOMMOOM@MNNMOO\"\"   '\"OXM@MM: :OO.        :...';o;.;Xb.\n" +
                        "  .@@MX\" ;X@@XXOOM@OOXXOO:o:'      :OXMNO\"' ;OOO;.:     ,OXMOOXXXOOXMb\n" +
                        " ,dMOo:  oO@@MNOON@N:::\"      .    ,;O:\"\"'  .dMXXO:    ,;OX@XO\":\"ON@M@\n" +
                        ":Y@MX:.  oO@M@NOXN@NO. ..: ,;;O;.       :.OX@@MOO;..   .OOMNMO.;XN@M@P\n" +
                        ",MP\"OO'  oO@M@O:ON@MO;;XO;:OXMNOO;.  ,.;.;OXXN@MNXO;.. oOX@NMMN@@@@@M:\n" +
                        "`' \"O:;;OON@@MN::XNMOOMXOOOM@@MMNXO:;XXNNMNXXXN@MNXOOOOOXNM@NM@@@M@MP\n" +
                        "   :XN@MMM@M@M:  :'OON@@XXNM@M@MXOOdN@@@MM@@@@MMNNXOOOXXNNN@@M@MMMM\"'\n" +
                        "   .oNM@MM@ONO'   :;ON@@MM@MMNNXXXM@@@@M@PY@@MMNNNNNNNNNNNM@M@M@@P'\n" +
                        "  ;O:OXM@MNOOO.   'OXOONM@MNNMMXON@MM@@b. 'Y@@@@@@@@@@@@@M@@MP\"'\n" +
                        " ;O':OOXNXOOXX:   :;NMO:\":NMMMXOOX@MN@@@@b.:M@@@M@@@MMM@\"\"\"\n" +
                        " :: ;\"OOOOOO@N;:  'ON@MO.'\":\"OOOO@@NNMN@@@. Y@@@MMM@@@@b\n" +
                        " :;   ':O:oX@@O;;  ;O@@XO'   \"oOOOOXMMNMNNN@MN\"\"YMNMMM@@MMo.\n" +
                        " :N:.   ''oOM@NMo.::OX@NOOo.  ;OOOXXNNNMMMNXNM@bd@MNNMMM@MM@bb\n" +
                        "  @;O .  ,OOO@@@MX;;ON@NOO.. ' ':OXN@NNN@@@@@M@@@@MNXNMM@MMM@,\n" +
                        "  M@O;;  :O:OX@@M@NXXOM@NOO;O;oOOXN@NNM@@'`\"@@M@@@@@MXNMMMMM@N\n" +
                        "  N@NOO;:oO;O:NMMM@M@OO@NOO;O;oOOXN@NNM@'   `Y@NM@@@@MMNNMM@MM\n" +
                        "  ::@MOO;oO:::OXNM@@MXOM@OOOOOOXNMMNNNMNP      \"\"MNNM@@@MMMM@MP\n" +
                        "    @@@XOOO':::OOXXMNOO@@OOOOXNN@NNNNNNNN        '`YMM@@@MMM@P'\n" +
                        "    MM@@M:'''' O:\":ONOO@MNOOOOXM@NM@NNN@P  -hrr-     \"`\"\"\"MM'\n" +
                        "    ''MM@:     \"' 'OOONMOYOOOOO@MM@MNNM\"\n" +
                        "      YM@'         :OOMN: :OOOO@MMNOXM'\n" +
                        "      `:P           :oP''  '\"OOM@NXNM'\n" +
                        "       `'                    ':OXNP'\n" +
                        "                               '\"'";

        
        System.out.println(dogshape);
    }
}
