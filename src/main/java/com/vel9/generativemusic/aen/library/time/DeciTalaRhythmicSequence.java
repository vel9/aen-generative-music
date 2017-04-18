package com.vel9.generativemusic.aen.library.time;

import com.vel9.generativemusic.aen.core.time.RhythmicElement;
import com.vel9.generativemusic.aen.core.time.RhythmicElementType;
import com.vel9.generativemusic.aen.core.time.RhythmicSequence;

import java.util.Arrays;

/**
 * Provides a number of RhythmicSequence representations of the amazing hindu deci talas
 */
public enum DeciTalaRhythmicSequence implements RhythmicSequence {

    // 1 - 5
    ADITALA(RhythmicElement.EIGHTH),
    DVITIYA(RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.EIGHTH),
    TRITIYA(RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.DOTTED_SIXTEENTH),
    CATURTHAKA(RhythmicElement.EIGHTH, RhythmicElement.EIGHTH, RhythmicElement.SIXTEENTH),
    PANCAMA(RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH),

    // 6 - 10
    NIHCANKALILA(RhythmicElement.DOTTED_QUARTER, RhythmicElement.DOTTED_QUARTER, RhythmicElement.QUARTER, RhythmicElement.QUARTER, RhythmicElement.EIGHTH),
    DARPANA(RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.QUARTER),
    SIMHAVIKRAMA(
            RhythmicElement.QUARTER,
            RhythmicElement.QUARTER,
            RhythmicElement.QUARTER,
            RhythmicElement.EIGHTH,
            RhythmicElement.DOTTED_QUARTER,
            RhythmicElement.QUARTER,
            RhythmicElement.DOTTED_QUARTER
    ),
    RATILILA(RhythmicElement.EIGHTH, RhythmicElement.EIGHTH, RhythmicElement.QUARTER, RhythmicElement.QUARTER),
    SIMHALILA(RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH),

    // 11 - 15
    KANDARPA(RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.EIGHTH, RhythmicElement.QUARTER, RhythmicElement.QUARTER),
    VIRAVIKRAMA(RhythmicElement.EIGHTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.QUARTER),
    RANGA(RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.QUARTER),
    CRIRANGA(RhythmicElement.EIGHTH, RhythmicElement.EIGHTH, RhythmicElement.QUARTER, RhythmicElement.EIGHTH, RhythmicElement.DOTTED_QUARTER),
    CACCARI(
            RhythmicElement.SIXTEENTH, RhythmicElement.DOTTED_SIXTEENTH,
            RhythmicElement.SIXTEENTH, RhythmicElement.DOTTED_SIXTEENTH,
            RhythmicElement.SIXTEENTH, RhythmicElement.DOTTED_SIXTEENTH,
            RhythmicElement.SIXTEENTH, RhythmicElement.DOTTED_SIXTEENTH,
            RhythmicElement.SIXTEENTH, RhythmicElement.DOTTED_SIXTEENTH,
            RhythmicElement.SIXTEENTH, RhythmicElement.DOTTED_SIXTEENTH,
            RhythmicElement.SIXTEENTH, RhythmicElement.DOTTED_SIXTEENTH,
            RhythmicElement.SIXTEENTH, RhythmicElement.DOTTED_SIXTEENTH
    ),

    //16 - 20
    PRATYANGA(RhythmicElement.QUARTER, RhythmicElement.QUARTER, RhythmicElement.QUARTER, RhythmicElement.EIGHTH, RhythmicElement.EIGHTH),
    YATILAGNA(RhythmicElement.SIXTEENTH, RhythmicElement.EIGHTH),
    GAJALILA(RhythmicElement.EIGHTH, RhythmicElement.EIGHTH, RhythmicElement.EIGHTH, new RhythmicElement(RhythmicElementType.EIGHTH, RhythmicElementType.SIXTEENTH)),
    HAMSALILA(RhythmicElement.DOTTED_EIGHTH, RhythmicElement.DOTTED_EIGHTH),
    VARNABHINNA(RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.EIGHTH, RhythmicElement.QUARTER),

    //21 - 25
    TRIBHINNA(RhythmicElement.EIGHTH, RhythmicElement.QUARTER, RhythmicElement.DOTTED_QUARTER),
    RAJACUDAMANI(
            RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.EIGHTH, RhythmicElement.EIGHTH, RhythmicElement.EIGHTH,
            RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.EIGHTH, RhythmicElement.QUARTER
    ),
    RANGADYOTA(
            RhythmicElement.QUARTER, RhythmicElement.QUARTER,
            RhythmicElement.QUARTER, RhythmicElement.EIGHTH, RhythmicElement.DOTTED_QUARTER
    ),
    RANGAPRADIPAKA(
            RhythmicElement.QUARTER, RhythmicElement.QUARTER,
            RhythmicElement.EIGHTH, RhythmicElement.QUARTER, RhythmicElement.DOTTED_QUARTER
    ),
    RAJATALA(
            RhythmicElement.QUARTER, RhythmicElement.DOTTED_QUARTER,
            RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.QUARTER,
            RhythmicElement.EIGHTH, RhythmicElement.DOTTED_QUARTER
    ),

    //26 - 30 (26 has a, b, c)
    TRYASRA_VARNA(
            RhythmicElement.EIGHTH, RhythmicElement.EIGHTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH,
            RhythmicElement.EIGHTH, RhythmicElement.EIGHTH
    ),
    MICRA_VARNA(
            RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.DOTTED_SIXTEENTH,
            RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.DOTTED_SIXTEENTH,
            RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.DOTTED_SIXTEENTH,
            RhythmicElement.DOTTED_QUARTER, RhythmicElement.QUARTER, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH,
            RhythmicElement.QUARTER, RhythmicElement.EIGHTH, RhythmicElement.QUARTER
    ),
    CATURASRA_VARNA(
            RhythmicElement.QUARTER, RhythmicElement.EIGHTH, RhythmicElement.SIXTEENTH,
            RhythmicElement.SIXTEENTH, RhythmicElement.QUARTER
    ),
    SIMHAVIKRIDITA(
            RhythmicElement.EIGHTH, RhythmicElement.DOTTED_QUARTER,
            RhythmicElement.QUARTER, RhythmicElement.DOTTED_QUARTER,
            RhythmicElement.DOTTED_QUARTER, RhythmicElement.QUARTER, RhythmicElement.EIGHTH,
            RhythmicElement.QUARTER, RhythmicElement.DOTTED_QUARTER,
            RhythmicElement.EIGHTH, RhythmicElement.DOTTED_QUARTER
    ),
    JAYA(
            RhythmicElement.EIGHTH, RhythmicElement.QUARTER, RhythmicElement.EIGHTH,
            RhythmicElement.EIGHTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.DOTTED_QUARTER
    ),
    VANAMALI(
            RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH,
            RhythmicElement.EIGHTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.DOTTED_QUARTER
    ),
    HAMSANADA(
            RhythmicElement.EIGHTH, RhythmicElement.DOTTED_QUARTER, RhythmicElement.SIXTEENTH,
            RhythmicElement.SIXTEENTH, RhythmicElement.DOTTED_QUARTER
    ),

    //31 - 35
    SIMHANADA(
            RhythmicElement.EIGHTH, RhythmicElement.QUARTER, RhythmicElement.QUARTER,
            RhythmicElement.EIGHTH, RhythmicElement.QUARTER
    ),
    KUDUKKA(RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.EIGHTH, RhythmicElement.EIGHTH),
    TURANGALILA(RhythmicElement.DOTTED_SIXTEENTH, RhythmicElement.DOTTED_SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH),
    CARABHALILA(
            RhythmicElement.EIGHTH, RhythmicElement.EIGHTH,
            RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH,
            RhythmicElement.EIGHTH, RhythmicElement.EIGHTH
    ),
    SIMHANANDANA(
            RhythmicElement.EIGHTH, RhythmicElement.QUARTER,
            RhythmicElement.EIGHTH, RhythmicElement.DOTTED_QUARTER,
            RhythmicElement.EIGHTH, RhythmicElement.QUARTER,
            RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.QUARTER,
            RhythmicElement.QUARTER, RhythmicElement.EIGHTH, RhythmicElement.QUARTER,
            RhythmicElement.EIGHTH, RhythmicElement.DOTTED_QUARTER, RhythmicElement.QUARTER,
            RhythmicElement.EIGHTH, RhythmicElement.EIGHTH, RhythmicElement.HALF
    ),

    //36 - 40 (38 has 4)
    TRIBHANGI(RhythmicElement.EIGHTH, RhythmicElement.QUARTER, RhythmicElement.EIGHTH, RhythmicElement.QUARTER),
    RANGABHARANA(
            RhythmicElement.QUARTER, RhythmicElement.QUARTER,
            RhythmicElement.EIGHTH, RhythmicElement.EIGHTH, RhythmicElement.DOTTED_QUARTER
    ),
    MANTHA1(
            RhythmicElement.EIGHTH, RhythmicElement.EIGHTH, RhythmicElement.QUARTER,
            RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH
    ),
    MANTHA2(
            RhythmicElement.QUARTER, RhythmicElement.EIGHTH, RhythmicElement.EIGHTH,
            RhythmicElement.QUARTER, RhythmicElement.EIGHTH, RhythmicElement.EIGHTH
    ),
    MANTHA3(
            RhythmicElement.QUARTER, RhythmicElement.EIGHTH, RhythmicElement.EIGHTH,
            RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH
    ),
    MANTHA4(
            RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH,
            RhythmicElement.QUARTER, RhythmicElement.EIGHTH, RhythmicElement.EIGHTH
    ),
    KOKILAPRIYA(RhythmicElement.QUARTER, RhythmicElement.EIGHTH, RhythmicElement.DOTTED_QUARTER),
    NIHAARUKA(RhythmicElement.DOTTED_QUARTER, RhythmicElement.DOTTED_QUARTER),

    //41-45
    RAJAVIDYADHARA(
            RhythmicElement.EIGHTH, RhythmicElement.QUARTER, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH
    ),
    JAYAMANGALA(
            RhythmicElement.EIGHTH, RhythmicElement.EIGHTH, RhythmicElement.QUARTER,
            RhythmicElement.EIGHTH, RhythmicElement.EIGHTH, RhythmicElement.QUARTER
    ),
    MALLIKAMODA(
            RhythmicElement.EIGHTH, RhythmicElement.EIGHTH,
            RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH
    ),
    VIJAYANANDA(
            RhythmicElement.EIGHTH, RhythmicElement.EIGHTH,
            RhythmicElement.QUARTER, RhythmicElement.QUARTER, RhythmicElement.QUARTER
    ),
    CANDANIHSARUKA(RhythmicElement.DOTTED_SIXTEENTH, RhythmicElement.DOTTED_SIXTEENTH),

    //46-50
    JAYACRI(
            RhythmicElement.QUARTER, RhythmicElement.EIGHTH,
            RhythmicElement.QUARTER, RhythmicElement.EIGHTH, RhythmicElement.QUARTER
    ),
    MAKARANDA(
            RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH,
            RhythmicElement.EIGHTH, RhythmicElement.EIGHTH, RhythmicElement.EIGHTH
    ),
    KIRTI(
            RhythmicElement.EIGHTH, RhythmicElement.DOTTED_QUARTER,
            RhythmicElement.QUARTER, RhythmicElement.EIGHTH, RhythmicElement.DOTTED_QUARTER
    ),
    CRIKIRTI(RhythmicElement.EIGHTH, RhythmicElement.EIGHTH, RhythmicElement.QUARTER, RhythmicElement.QUARTER),
    PRATILALA(RhythmicElement.EIGHTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH),

    //51-55 (55 as 2)
    VIJAYA(RhythmicElement.DOTTED_QUARTER, RhythmicElement.QUARTER, RhythmicElement.DOTTED_QUARTER),
    BINDUMALI(
            RhythmicElement.QUARTER,
            RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH,
            RhythmicElement.QUARTER
    ),
    SAMA(RhythmicElement.EIGHTH, RhythmicElement.EIGHTH, RhythmicElement.DOTTED_SIXTEENTH, RhythmicElement.DOTTED_SIXTEENTH),
    NANDANA(RhythmicElement.EIGHTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.DOTTED_QUARTER),
    MANTHIKA1(RhythmicElement.QUARTER, RhythmicElement.SIXTEENTH, RhythmicElement.DOTTED_QUARTER),
    MANTHIKA2(RhythmicElement.DOTTED_SIXTEENTH, RhythmicElement.SIXTEENTH),

    //56 - 60
    DIPAKA(
            RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.EIGHTH, RhythmicElement.EIGHTH,
            RhythmicElement.QUARTER, RhythmicElement.QUARTER
    ),
    UDIKSHANA(RhythmicElement.EIGHTH, RhythmicElement.EIGHTH, RhythmicElement.QUARTER),
    DHENKI(RhythmicElement.QUARTER, RhythmicElement.EIGHTH, RhythmicElement.QUARTER),
    VISHAMA(
            RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.DOTTED_SIXTEENTH,
            RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.DOTTED_SIXTEENTH
    ),
    VARNAMANTHIKA(
            RhythmicElement.EIGHTH, RhythmicElement.EIGHTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH,
            RhythmicElement.EIGHTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH
    ),

    //61 - 65 (4 in 65)
    ABHINANDA(
            RhythmicElement.EIGHTH, RhythmicElement.EIGHTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH,
            RhythmicElement.QUARTER
    ),
    ANANGA(
            RhythmicElement.EIGHTH, RhythmicElement.DOTTED_QUARTER,
            RhythmicElement.EIGHTH, RhythmicElement.EIGHTH, RhythmicElement.QUARTER
    ),
    NANDI(
            RhythmicElement.EIGHTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH,
            RhythmicElement.EIGHTH, RhythmicElement.EIGHTH, RhythmicElement.QUARTER, RhythmicElement.QUARTER
    ),
    MALLATALA(
            RhythmicElement.EIGHTH, RhythmicElement.EIGHTH, RhythmicElement.EIGHTH, RhythmicElement.EIGHTH,
            RhythmicElement.SIXTEENTH, RhythmicElement.DOTTED_SIXTEENTH
    ),
    KANKALA_PURNA(
            RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH,
            RhythmicElement.QUARTER, RhythmicElement.EIGHTH
    ),
    KANKALA_KHANDA(
            RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.QUARTER, RhythmicElement.QUARTER
    ),
    KANKALA_SAMA(RhythmicElement.QUARTER, RhythmicElement.QUARTER, RhythmicElement.EIGHTH),
    KANKALA_VISHAMA(RhythmicElement.EIGHTH, RhythmicElement.QUARTER, RhythmicElement.QUARTER),

    // 66 - 70 (2 in 68)
    KANDUKA(
            RhythmicElement.EIGHTH, RhythmicElement.EIGHTH, RhythmicElement.EIGHTH, RhythmicElement.EIGHTH,
            RhythmicElement.QUARTER
    ),
    EKATALI(RhythmicElement.SIXTEENTH),
    KAMUDA1(
            RhythmicElement.EIGHTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH,
            RhythmicElement.EIGHTH, RhythmicElement.EIGHTH, RhythmicElement.QUARTER
    ),
    KAMUDA2(
            RhythmicElement.EIGHTH,
            RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH,
            RhythmicElement.QUARTER
    ),
    CATUSTALA(RhythmicElement.QUARTER, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH),
    DOMBULI(RhythmicElement.DOTTED_EIGHTH, RhythmicElement.DOTTED_EIGHTH),

    // 71 - 75
    ABHANGA(RhythmicElement.EIGHTH, RhythmicElement.DOTTED_QUARTER),
    RAYAVANKOLA(
            RhythmicElement.QUARTER, RhythmicElement.EIGHTH, RhythmicElement.QUARTER,
            RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH
    ),
    VASANTA(
            RhythmicElement.EIGHTH, RhythmicElement.EIGHTH, RhythmicElement.EIGHTH,
            RhythmicElement.QUARTER, RhythmicElement.QUARTER, RhythmicElement.QUARTER
    ),
    LAGHUCEKHARA(RhythmicElement.DOTTED_EIGHTH),
    PRATAPACEKHARA(RhythmicElement.DOTTED_QUARTER, RhythmicElement.SIXTEENTH, RhythmicElement.DOTTED_SIXTEENTH),

    // 76 - 80
    JHAMPA(RhythmicElement.DOTTED_SIXTEENTH, RhythmicElement.DOTTED_SIXTEENTH, RhythmicElement.EIGHTH),
    GAJAJHAMPA(RhythmicElement.QUARTER, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.DOTTED_SIXTEENTH),
    CATURMUKHA(RhythmicElement.EIGHTH, RhythmicElement.QUARTER, RhythmicElement.EIGHTH, RhythmicElement.DOTTED_QUARTER),
    MADANA(RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.QUARTER),
    PRATIMANTHAKA(
            RhythmicElement.EIGHTH, RhythmicElement.EIGHTH, RhythmicElement.QUARTER,
            RhythmicElement.QUARTER, RhythmicElement.EIGHTH, RhythmicElement.EIGHTH
    ),

    // 81 - 85
    PARVATILOCANA(
            RhythmicElement.QUARTER, RhythmicElement.QUARTER, RhythmicElement.QUARTER, RhythmicElement.EIGHTH,
            RhythmicElement.DOTTED_QUARTER, RhythmicElement.QUARTER, RhythmicElement.QUARTER,
            RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH
    ),
    RATI(RhythmicElement.EIGHTH, RhythmicElement.QUARTER),
    LILA(RhythmicElement.SIXTEENTH, RhythmicElement.EIGHTH, RhythmicElement.DOTTED_QUARTER),
    KARANAYATI(RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH),
    LALITA(RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.EIGHTH, RhythmicElement.QUARTER),

    // 86 - 90
    GARUGI(RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.DOTTED_SIXTEENTH),
    RAJANARAYANA(
            RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.EIGHTH, RhythmicElement.QUARTER,
            RhythmicElement.EIGHTH, RhythmicElement.QUARTER
    ),
    LAKSKMICA(RhythmicElement.SIXTEENTH, RhythmicElement.DOTTED_SIXTEENTH, RhythmicElement.EIGHTH, RhythmicElement.QUARTER),
    LALITAPRIYA(
            RhythmicElement.EIGHTH, RhythmicElement.EIGHTH, RhythmicElement.QUARTER,
            RhythmicElement.EIGHTH, RhythmicElement.QUARTER
    ),
    CRINANDANA(RhythmicElement.QUARTER, RhythmicElement.EIGHTH, RhythmicElement.EIGHTH, RhythmicElement.DOTTED_QUARTER),

    // 91 - 95
    JANAKA(
            RhythmicElement.EIGHTH, RhythmicElement.EIGHTH, RhythmicElement.EIGHTH, RhythmicElement.EIGHTH,
            RhythmicElement.QUARTER, RhythmicElement.QUARTER, RhythmicElement.QUARTER,
            RhythmicElement.EIGHTH, RhythmicElement.EIGHTH, RhythmicElement.QUARTER
    ),
    VARDHANA(RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.EIGHTH, RhythmicElement.DOTTED_QUARTER),
    RAGAVARDHANA(RhythmicElement.SIXTEENTH, RhythmicElement.DOTTED_SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.DOTTED_QUARTER),
    SHATTALA(
            RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH,
            RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH
    ),
    ANTARAKRIDA(RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH),

    // 96 - 100
    HAMSA(RhythmicElement.EIGHTH, RhythmicElement.DOTTED_EIGHTH),
    UTSAVA(RhythmicElement.EIGHTH, RhythmicElement.DOTTED_QUARTER),
    VILOKITA(RhythmicElement.QUARTER, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.DOTTED_EIGHTH),
    GAJA(RhythmicElement.EIGHTH, RhythmicElement.EIGHTH, RhythmicElement.EIGHTH, RhythmicElement.EIGHTH),
    VARNAYATI(RhythmicElement.EIGHTH, RhythmicElement.EIGHTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH),

    // 101 - 105
    SIMHA(RhythmicElement.EIGHTH, RhythmicElement.SIXTEENTH, RhythmicElement.EIGHTH, RhythmicElement.EIGHTH, RhythmicElement.EIGHTH),
    KARUNA(RhythmicElement.QUARTER),
    SARASA(
            RhythmicElement.EIGHTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH,
            RhythmicElement.EIGHTH, RhythmicElement.EIGHTH
    ),
    CANDATALA(
            RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH,
            RhythmicElement.EIGHTH, RhythmicElement.EIGHTH
    ),
    CANDRAKALA(
            RhythmicElement.QUARTER, RhythmicElement.QUARTER, RhythmicElement.QUARTER,
            RhythmicElement.DOTTED_QUARTER, RhythmicElement.DOTTED_QUARTER, RhythmicElement.DOTTED_QUARTER,
            RhythmicElement.EIGHTH
    ),

    // 106 - 110
    LAYA(
            RhythmicElement.QUARTER, RhythmicElement.EIGHTH, RhythmicElement.DOTTED_QUARTER,
            RhythmicElement.DOTTED_QUARTER, RhythmicElement.DOTTED_QUARTER, RhythmicElement.QUARTER,
            RhythmicElement.DOTTED_QUARTER, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH
    ),
    SKANDA(
            RhythmicElement.QUARTER, RhythmicElement.EIGHTH, RhythmicElement.QUARTER,
            RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.QUARTER, RhythmicElement.QUARTER
    ),
    TRIPUTA(RhythmicElement.SIXTEENTH, RhythmicElement.EIGHTH, RhythmicElement.EIGHTH),
    DHATTA(
            RhythmicElement.EIGHTH, RhythmicElement.EIGHTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH,
            RhythmicElement.EIGHTH, RhythmicElement.QUARTER
    ),
    DVANDVA(
            RhythmicElement.EIGHTH, RhythmicElement.EIGHTH, RhythmicElement.QUARTER, RhythmicElement.QUARTER,
            RhythmicElement.QUARTER, RhythmicElement.EIGHTH, RhythmicElement.DOTTED_QUARTER
    ),

    // 111 - 115
    MUKUNDA(
            RhythmicElement.EIGHTH,
            RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH,
            RhythmicElement.QUARTER
    ),
    KUVINDAKA(
            RhythmicElement.EIGHTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH,
            RhythmicElement.QUARTER, RhythmicElement.DOTTED_QUARTER
    ),
    KALADHVANI(
            RhythmicElement.EIGHTH, RhythmicElement.EIGHTH, RhythmicElement.QUARTER,
            RhythmicElement.EIGHTH, RhythmicElement.DOTTED_QUARTER
    ),
    GAURI(
            RhythmicElement.EIGHTH, RhythmicElement.EIGHTH, RhythmicElement.EIGHTH,
            RhythmicElement.EIGHTH, RhythmicElement.EIGHTH
    ),
    SARASVATIKANTHABHARANA(
            RhythmicElement.QUARTER, RhythmicElement.QUARTER, RhythmicElement.EIGHTH, RhythmicElement.EIGHTH,
            RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH
    ),

    // 116 - 120
    BHAGNA(
            RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH,
            RhythmicElement.EIGHTH, RhythmicElement.EIGHTH, RhythmicElement.DOTTED_EIGHTH
    ),
    RAJAMRIGANKA(RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.EIGHTH, RhythmicElement.QUARTER),
    RAJAMARTANDA(RhythmicElement.QUARTER, RhythmicElement.EIGHTH, RhythmicElement.SIXTEENTH),
    NICCANKA(
            RhythmicElement.EIGHTH, RhythmicElement.QUARTER, RhythmicElement.QUARTER,
            RhythmicElement.DOTTED_QUARTER, RhythmicElement.QUARTER,
            RhythmicElement.QUARTER, RhythmicElement.QUARTER, RhythmicElement.EIGHTH
    ),
    CARNGADEVA(
            RhythmicElement.SIXTEENTH, RhythmicElement.SIXTEENTH, RhythmicElement.QUARTER,
            RhythmicElement.DOTTED_QUARTER, RhythmicElement.QUARTER,
            RhythmicElement.QUARTER, RhythmicElement.EIGHTH
    );

    private RhythmicElement[] rhythmicElements;

    DeciTalaRhythmicSequence(RhythmicElement... rhythmicElements){
        this.rhythmicElements = rhythmicElements;
    }

    @Override
    public RhythmicElement[] getRhythmicSequence(){
        return rhythmicElements;
    }

    @Override
    public boolean isSilence(){
        return false;
    }

    @Override
    public String toString(){
        return Arrays.toString(rhythmicElements);
    }

    public static RhythmicSequence[] getFastSequences(){
       return new RhythmicSequence[]{
               DVITIYA,
               TRITIYA,
               CATURTHAKA,
               PANCAMA,
               SIMHALILA,
               KANDARPA,
               RANGA,
               VIRAVIKRAMA,
               CACCARI,
               YATILAGNA,
               VARNABHINNA,
               MICRA_VARNA,
               VANAMALI,
               MAKARANDA,
               MANTHIKA2,
               VISHAMA,
               KANKALA_PURNA,
               EKATALI,
               MADANA,
               LILA,
               LAKSKMICA,
               VARDHANA,
               RAGAVARDHANA,
               SHATTALA,
               ANTARAKRIDA,
               CANDATALA,
               TRIPUTA,
               MUKUNDA,
               BHAGNA,
               RAJAMRIGANKA
       };
    }

}
