# AEN: Generative Music

Please check out the [detailed description](http://vel9.com/aen/aen.html) which outlines the goal, the context, and the approach taken -- and most importantly: the generated music itself. 

If you want to try and generate some music, you need two main components: 

1. A Java environment where you can just run some mains, there are no third-party library dependencies. 
2. A receiver which is able to translate the MIDI signals the algorithm outputs in some sound. Your system may actually be able to just automatically render the signals usings its built-in MIDI synthesizer. But I would highly recommend using something like Ableton Live where you'd have a lot of control over the receiver instruments. Here's a [guide](https://help.ableton.com/hc/en-us/articles/209774225-Using-virtual-MIDI-buses-in-Live) for how I set up Ableton Live as the Receiver for the MIDI signals.

This repo contains the source for how I generated some of the pieces, check out [GardenMain.java](https://github.com/vel9/aen-generative-music/blob/master/src/main/java/com/vel9/generativemusic/aen/pieces/garden/GardenMain.java)

As a quick example: the following line will output MIDI signls to Channel 1. 

```Instrument.play(GardenPluckedPianoSource.getMelody(), 0);``` 
