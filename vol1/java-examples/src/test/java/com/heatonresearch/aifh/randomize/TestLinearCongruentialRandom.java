package com.heatonresearch.aifh.randomize;

import com.heatonresearch.aifh.AIFH;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: jheaton
 * Date: 9/2/13
 * Time: 3:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestLinearCongruentialRandom {
    public static boolean[] BOOLEAN_TEST = {
            false, true, false, true, true, true, true, true, true, false,
            false, false, false, true, false, true, true, true, true, true,
            true, true, false, false, false, false, false, true, false, true,
            true, true, true, false, true, true, false, true, true, false,
            true, false, false, false, false, false, true, true, true, false,
            false, true, false, true, true, false, true, true, false, true,
            false, false, false, true, false, false, true, false, false, false,
            true, false, true, false, false, false, true, false, false, true,
            false, true, true, false, true, true, true, true, true, false,
            false, true, true, false, true, false, true, true, false, true,
    };

    public static double[] DOUBLE_RANGE_TEST = {
            -0.48612992174134817, 0.17574130352021688, -0.6913484837141234, 0.5345338870618803, 0.9476279257674767, 0.17173630166140774, 0.7022311691432799, 0.2264306813540009, 0.4947734469302869, -0.8752796803310698,
            -0.9161011967612667, -0.6103528788337375, -0.722774202870851, 0.36807071961650406, -0.016562808076050817, 0.5353979402071325, 0.7656819032890914, 0.6464731506180188, 0.7671388112397721, 0.7802369212220044,
            0.822951422497386, 0.15193229335172398, -0.37452325955371446, -0.685315172580377, -0.6530989193481158, -0.08279552335915985, -0.4802400636207871, 0.4011542078575945, -0.393241616756013, 0.7854021694011526,
            0.9315228801992543, 0.8699210742185639, 0.8665246995786495, -0.32547965304122295, 0.7583996005725115, 0.58189345793377, -0.6107522760542929, 0.35563473574715543, 0.20023207394411613, -0.17307316073520884,
            0.415903314346425, -0.5364780727626006, -0.020837003137179844, -0.8735635480549102, -0.7873633009817831, -0.04154862673989235, 0.737462934511123, 0.40905646314124033, 0.7801130669610838, -0.24210074945401883,
            -0.04315815657450772, 0.02809602651467924, -0.6812724759060127, 0.7569342050135448, 0.2429949718627602, -0.4104577855697036, 0.043424434271507106, 0.9560249671237602, -0.6808668690921895, 0.05935982127193351,
            -0.5581238743751598, -0.08498015466262121, -0.4277526548662578, 0.11883804274695886, -0.4302290201723178, -0.7479519065813981, 0.49585787427980876, -0.7632659687109445, -0.5230391089625281, -0.5939068481311917,
            0.8729976121971843, -0.5730366738450333, 0.3582181030321443, -0.6180122349453188, -0.9568201396513777, -0.8394128433054808, 0.5223514189762881, -0.3034190259183336, -0.9028995223117293, 0.4008466236760948,
            -0.2265682116212715, 0.24482698348463217, 0.3428244016465787, -0.7700062482082299, 0.29787726823656757, 0.3045459034164777, 0.8872065474016606, 0.036669422648071714, 0.6511473575726028, -0.6013936329636242,
            -0.323702918208135, 0.732578176011466, 0.9377967095789026, -0.7667199768514186, 0.83848107276449, -0.03279010882433275, 0.7786382170809987, 0.43151790262933765, -0.32589749044876026, 0.8093583425063078
    };

    public static double[] DOUBLE_TEST = {
            0.2569350391293259, 0.5878706517601084, 0.1543257581429383, 0.7672669435309402, 0.9738139628837383, 0.5858681508307039, 0.8511155845716399, 0.6132153406770005, 0.7473867234651435, 0.06236015983446505,
            0.041949401619366694, 0.19482356058313127, 0.1386128985645745, 0.684035359808252, 0.4917185959619746, 0.7676989701035662, 0.8828409516445457, 0.8232365753090094, 0.8835694056198861, 0.8901184606110022,
            0.911475711248693, 0.575966146675862, 0.31273837022314277, 0.1573424137098115, 0.17345054032594212, 0.4586022383204201, 0.25987996818960646, 0.7005771039287972, 0.3033791916219935, 0.8927010847005763,
            0.9657614400996272, 0.934960537109282, 0.9332623497893248, 0.3372601734793885, 0.8791998002862558, 0.790946728966885, 0.1946238619728535, 0.6778173678735777, 0.6001160369720581, 0.4134634196323956,
            0.7079516571732125, 0.2317609636186997, 0.4895814984314101, 0.06321822597254492, 0.10631834950910843, 0.4792256866300538, 0.8687314672555615, 0.7045282315706202, 0.8900565334805419, 0.3789496252729906,
            0.47842092171274614, 0.5140480132573396, 0.15936376204699365, 0.8784671025067724, 0.6214974859313801, 0.2947711072151482, 0.5217122171357536, 0.9780124835618801, 0.15956656545390527, 0.5296799106359668,
            0.2209380628124201, 0.4575099226686894, 0.2861236725668711, 0.5594190213734794, 0.2848854899138411, 0.12602404670930095, 0.7479289371399044, 0.11836701564452774, 0.2384804455187359, 0.20304657593440417,
            0.9364988060985922, 0.21348166307748334, 0.6791090515160721, 0.19099388252734065, 0.021589930174311142, 0.08029357834725957, 0.7611757094881441, 0.3482904870408332, 0.04855023884413537, 0.7004233118380474,
            0.38671589418936425, 0.6224134917423161, 0.6714122008232893, 0.11499687589588502, 0.6489386341182838, 0.6522729517082388, 0.9436032737008303, 0.5183347113240359, 0.8255736787863014, 0.19930318351818788,
            0.3381485408959325, 0.866289088005733, 0.9688983547894513, 0.1166400115742907, 0.919240536382245, 0.4836049455878336, 0.8893191085404993, 0.7157589513146688, 0.33705125477561987, 0.9046791712531539
    };

    public static long[] LONG_TEST = {
            1103527590l, 2524885223l, 662824084l, 3295386429l, 4182499122l, 2516284547l, 3655513600l, 2633739833l, 3210001534l, 267834847l,
            180171308l, 836760821l, 595337866l, 2937909499l, 2111915288l, 3297241969l, 3791773014l, 3535774167l, 3794901700l, 3823029677l,
            3914758370l, 2473755763l, 1343201072l, 675780521l, 744964398l, 1969681615l, 1116175964l, 3008955749l, 1303003706l, 3834121963l,
            4147913800l, 4015624929l, 4008331270l, 1448521415l, 3776134388l, 3397090333l, 835903122l, 2911203427l, 2577478752l, 1775811865l,
            3040629214l, 995405759l, 2102736524l, 271520213l, 456633834l, 2058258651l, 3731173240l, 3025925713l, 3822763702l, 1627576247l,
            2054802212l, 2207819405l, 684462146l, 3772987475l, 2669311376l, 1266032265l, 2240736910l, 4200531631l, 685333180l, 2274957893l,
            948921754l, 1964990155l, 1228891816l, 2402686401l, 1223573862l, 541269159l, 3212330324l, 508382461l, 1024265714l, 872078403l,
            4022231744l, 916896761l, 2916751166l, 820312479l, 92728044l, 344858293l, 3269224778l, 1495896251l, 208521688l, 3008295217l,
            1660932118l, 2673245591l, 2883693444l, 493907821l, 2787170210l, 2801490995l, 4052745200l, 2226230633l, 3545811950l, 856000655l,
            1452336924l, 3720683301l, 4161386746l, 500965035l, 3948108040l, 2077067425l, 3819596486l, 3074161287l, 1447624116l, 3885567453l};

    public static float[] FLOAT_TEST = {
            0.2569350302219391f, 0.5878706574440002f, 0.15432575345039368f, 0.7672669291496277f, 0.9738139510154724f, 0.5858681797981262f, 0.8511155843734741f, 0.6132153272628784f, 0.7473866939544678f, 0.06236016005277634f,
            0.041949402540922165f, 0.19482356309890747f, 0.13861289620399475f, 0.6840353608131409f, 0.491718590259552f, 0.7676989436149597f, 0.8828409314155579f, 0.8232365846633911f, 0.8835694193840027f, 0.8901184797286987f,
            0.9114757180213928f, 0.5759661197662354f, 0.3127383589744568f, 0.15734241902828217f, 0.1734505444765091f, 0.45860224962234497f, 0.2598799765110016f, 0.7005770802497864f, 0.3033791780471802f, 0.8927010893821716f,
            0.9657614231109619f, 0.9349605441093445f, 0.9332623481750488f, 0.3372601866722107f, 0.8791998028755188f, 0.7909467220306396f, 0.19462385773658752f, 0.6778173446655273f, 0.6001160144805908f, 0.41346341371536255f,
            0.7079516649246216f, 0.23176096379756927f, 0.48958149552345276f, 0.06321822851896286f, 0.10631834715604782f, 0.47922569513320923f, 0.8687314391136169f, 0.7045282125473022f, 0.8900565505027771f, 0.3789496123790741f,
            0.4784209132194519f, 0.5140480399131775f, 0.1593637615442276f, 0.8784670829772949f, 0.6214975118637085f, 0.29477110505104065f, 0.5217122435569763f, 0.9780125021934509f, 0.15956656634807587f, 0.5296798944473267f,
            0.2209380567073822f, 0.45750993490219116f, 0.286123663187027f, 0.5594190359115601f, 0.2848854959011078f, 0.1260240525007248f, 0.7479289174079895f, 0.1183670163154602f, 0.23848044872283936f, 0.20304657518863678f,
            0.9364988207817078f, 0.21348166465759277f, 0.6791090369224548f, 0.19099387526512146f, 0.02158993110060692f, 0.08029358088970184f, 0.7611756920814514f, 0.34829047322273254f, 0.04855024069547653f, 0.7004233002662659f,
            0.3867158889770508f, 0.6224135160446167f, 0.6714122295379639f, 0.11499687284231186f, 0.6489386558532715f, 0.6522729396820068f, 0.9436032772064209f, 0.518334686756134f, 0.8255736827850342f, 0.19930317997932434f,
            0.3381485342979431f, 0.8662890791893005f, 0.968898355960846f, 0.11664000898599625f, 0.9192405343055725f, 0.48360493779182434f, 0.889319121837616f, 0.7157589793205261f, 0.33705124258995056f, 0.9046791791915894f
    };

    public static double[] GAUSSIAN_TEST = {
            -1.527867918611873, 0.5523410257524433, -0.5809103325840359, 0.44914578598968136, 0.38177877335247723, 0.06918883752321084, 1.0495756611251017, 0.33843005341257154, -0.8154818859744846, 0.41528184516359345,
            -0.04886125855186846, 1.5794554319822844, 0.8300114632539505, 0.15323570951211696, -0.47687411555770254, -0.8726001882819518, -1.2828754294857758, -0.16263438729143906, -1.0509748709741087, 0.8779004997316662,
            -0.3224877081102097, 0.6440888623243397, 0.5204606363296946, -0.1954928087065194, 0.336931167723857, 0.25851548725038237, -1.0182260820170441, 0.5929025200665851, 1.744530626770596, -1.5079074177637979,
            0.762711744765927, -0.9838299258288712, -0.017516087941127398, -0.734338610459317, -0.9736840370790784, -0.05138064546410212, 0.7219973974419484, 0.40047802807956484, 0.8592208705059003, -0.2666511118783631,
            -2.886732781821573, 1.8792674946352896, 0.8766086989237702, -1.4807337889057448, 0.019023090267626382, 0.41880912331500236, -1.2291970916298267, 0.10716473804109791, -1.4950065831007056, -0.2276302743647499,
            -1.7364909932570731, 0.4824311165313854, -0.3829899463668436, -0.6658269134700728, 0.33423161528349127, -0.514477294494314, -0.639369048639969, -0.7259985916227291, 0.5817303475386397, -1.0036245214151305,
            1.2278146345886816, -0.7132024665794654, -0.20186061139366995, 0.08961699782847886, -1.423348377533755, 1.5380537597297164, 0.3363227016975248, -0.7554030007127155, 1.2918344216938809, 1.320754965118111,
            0.6888291927734245, 0.028470223620547068, 0.5102504981466464, -0.471262606279863, -0.3808716490136929, 0.8619578083306831, 0.8369739804151773, -0.032731171629746654, 0.5965443100662773, 0.33060225385583264,
            -0.27588150409514267, 0.6851448796832588, -0.5841294404311771, 0.20008254936391154, 0.37853376118381415, 0.4810659063333846, -0.39067708184448036, -0.29661285379192637, -1.9577989602721633, -1.1125575176253402,
            0.9872547885012775, 1.0791184369376612, 0.5021384279903195, 0.4647676239621373, -0.6019408416619572, 0.36117765197196544, 0.9561278557955517, 0.09539874345031751, -0.06555305960950418, -0.106095177636118
    };

    public static int[] INT_TEST = {
            1103527590, -1770082073, 662824084, -999580867, -112468174, -1778682749, -639453696, -1661227463, -1084965762, 267834847,
            180171308, 836760821, 595337866, -1357057797, 2111915288, -997725327, -503194282, -759193129, -500065596, -471937619,
            -380208926, -1821211533, 1343201072, 675780521, 744964398, 1969681615, 1116175964, -1286011547, 1303003706, -460845333,
            -147053496, -279342367, -286636026, 1448521415, -518832908, -897876963, 835903122, -1383763869, -1717488544, 1775811865,
            -1254338082, 995405759, 2102736524, 271520213, 456633834, 2058258651, -563794056, -1269041583, -472203594, 1627576247,
            2054802212, -2087147891, 684462146, -521979821, -1625655920, 1266032265, -2054230386, -94435665, 685333180, -2020009403,
            948921754, 1964990155, 1228891816, -1892280895, 1223573862, 541269159, -1082636972, 508382461, 1024265714, 872078403,
            -272735552, 916896761, -1378216130, 820312479, 92728044, 344858293, -1025742518, 1495896251, 208521688, -1286672079,
            1660932118, -1621721705, -1411273852, 493907821, -1507797086, -1493476301, -242222096, -2068736663, -749155346, 856000655,
            1452336924, -574283995, -133580550, 500965035, -346859256, 2077067425, -475370810, -1220806009, 1447624116, -409399843
    };

    public static int[] INT_RANGE_TEST = {
            2, 5, 1, 7, 9, 5, 8, 6, 7, 0,
            0, 1, 1, 6, 4, 7, 8, 8, 8, 8,
            9, 5, 3, 1, 1, 4, 2, 7, 3, 8,
            9, 9, 9, 3, 8, 7, 1, 6, 6, 4,
            7, 2, 4, 0, 1, 4, 8, 7, 8, 3,
            4, 5, 1, 8, 6, 2, 5, 9, 1, 5,
            2, 4, 2, 5, 2, 1, 7, 1, 2, 2,
            9, 2, 6, 1, 0, 0, 7, 3, 0, 7,
            3, 6, 6, 1, 6, 6, 9, 5, 8, 1,
            3, 8, 9, 1, 9, 4, 8, 7, 3, 9,
    };

    @Test
    public void testGenerateBoolean() {
        LinearCongruentialRandom rnd = new LinearCongruentialRandom(1);
        for (int i = 0; i < BOOLEAN_TEST.length; i++) {
            boolean g = rnd.nextBoolean();
            assertEquals(g, BOOLEAN_TEST[i]);
        }
    }

    @Test
    public void testDoubleRange() {
        LinearCongruentialRandom rnd = new LinearCongruentialRandom(1);
        for (int i = 0; i < DOUBLE_RANGE_TEST.length; i++) {
            double g = rnd.nextDouble(-1, 1);
            assertEquals(g, DOUBLE_RANGE_TEST[i], AIFH.DEFAULT_PRECISION);
        }
    }

    @Test
    public void testDouble() {
        LinearCongruentialRandom rnd = new LinearCongruentialRandom(1);
        for (int i = 0; i < DOUBLE_TEST.length; i++) {
            double g = rnd.nextDouble();
            assertEquals(g, DOUBLE_TEST[i], AIFH.DEFAULT_PRECISION);
        }
    }

    @Test
    public void testLong() {
        LinearCongruentialRandom rnd = new LinearCongruentialRandom(1);
        for (int i = 0; i < LONG_TEST.length; i++) {
            long l = rnd.nextLong();
            assertEquals(l, LONG_TEST[i], AIFH.DEFAULT_PRECISION);
        }
    }

    @Test
    public void testFloat() {
        LinearCongruentialRandom rnd = new LinearCongruentialRandom(1);
        for (int i = 0; i < FLOAT_TEST.length; i++) {
            float l = (float) rnd.nextFloat();
            assertEquals(l, FLOAT_TEST[i], AIFH.DEFAULT_PRECISION);
        }
    }

    @Test
    public void testGaussianFloat() {
        LinearCongruentialRandom rnd = new LinearCongruentialRandom(1);
        for (int i = 0; i < GAUSSIAN_TEST.length; i++) {
            double g = rnd.nextGaussian();
            assertEquals(g, GAUSSIAN_TEST[i], AIFH.DEFAULT_PRECISION);
        }
    }

    @Test
    public void testInt() {
        LinearCongruentialRandom rnd = new LinearCongruentialRandom(1);
        for (int i = 0; i < INT_TEST.length; i++) {
            int g = rnd.nextInt();
            assertEquals(g, INT_TEST[i], AIFH.DEFAULT_PRECISION);
        }
    }

    @Test
    public void testIntRange() {
        LinearCongruentialRandom rnd = new LinearCongruentialRandom(1);
        for (int i = 0; i < INT_RANGE_TEST.length; i++) {
            double g = rnd.nextInt(0, 10);
            assertEquals(g, INT_RANGE_TEST[i], AIFH.DEFAULT_PRECISION);
        }
    }

    @Test
    public void testBasic() {
        LinearCongruentialRandom rnd = new LinearCongruentialRandom();
        rnd.getSeed();
        assertEquals(12345, rnd.getIncrement());
        assertEquals(4294967296l, rnd.getModulus());
        assertEquals(1103515245, rnd.getMultiplier());
    }


    /*public static void main(String[] args) {
        LinearCongruentialRandom rnd = new LinearCongruentialRandom(1);
        for(int row=0;row<10;row++) {
            StringBuilder result = new StringBuilder();

            for(int col=0;col<10;col++) {
                if( col>0 ) {
                    result.append(",");
                }
                result.append(rnd.nextInt(10));
            }
            result.append(",");
            System.out.println(result.toString());
        }
    }*/
}
