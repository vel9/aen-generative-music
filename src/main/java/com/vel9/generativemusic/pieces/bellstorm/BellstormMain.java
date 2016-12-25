package com.vel9.generativemusic.pieces.bellstorm;

import com.vel9.generativemusic.core.perform.Instrument;
import com.vel9.generativemusic.pieces.bellstorm.melodysources.*;

/**
 *
 O  C	C#	D	D#	E	F	F#	G	G#	A	A#	B
 -2	0	1	2	3	4	5	6	7	8	9	10	11
 -1	12	13	14	15	16	17	18	19	20	21	22	23
 0	24	25	26	27	28	29	30	31	32	33	34	35
 1	36	37	38	39	40	41	42	43	44	45	46	47
 2	48	49	50	51	52	53	54	55	56	57	58	59
 3	60	61	62	63	64	65	66	67	68	69	70	71
 4	72	73	74	75	76	77	78	79	80	81	82	83
 5	84	85	86	87	88	89	90	91	92	93	94	95
 6	96	97	98	99	100	101	102	103	104	105	106	107
 7	108	109	110	111	112	113	114	115	116	117	118	119
 8	120	121	122	123	124	125	126	127
 */
public class BellstormMain {

    public static void main(String[] args) {
        Instrument.play(BellstormMalletPianoSource.getMelody(), 0);
        Instrument.play(BellstormArmonicaLeftMelodySource.getMelody(), 1);
        Instrument.play(BellstormMutedPianoMelodySource.getMelody(), 2);
        Instrument.play(BellstormArmonicaRightMelodySource.getMelody(), 3);

        //Instrument.play(FourGlockenMelodySource.getMelody(), 3);
        //Instrument.play(FourBowedPianoMelodySource.getMelody(), 4);
        //Instrument.play(FourCopenhagenMelodySource.getMelody(), 6);
    }
}
