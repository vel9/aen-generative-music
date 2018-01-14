# AEN: Generative Music

Please check out the [story behind the project, and the music it can create](http://vel9.com/aen/aen.html).

To start generating music, you need:

1. A basic Java development environment, there are no third-party library dependencies.
2. A receiver which is able to translate the MIDI signals the algorithm outputs in sound. Your system could be able to just render the signals out-of-the-box, using its built-in MIDI synthesizer. But I would highly recommend using something like Ableton Live where you'd have a lot of control over the receiver instruments. Here's a [guide](https://help.ableton.com/hc/en-us/articles/209774225-Using-virtual-MIDI-buses-in-Live) for how I set up Ableton Live as the Receiver for the MIDI signals.

This repo also contains plenty of example code for how to generate music, check out [GardenMain.java](https://github.com/vel9/aen-generative-music/blob/master/src/main/java/com/vel9/generativemusic/aen/pieces/garden/GardenMain.java).
