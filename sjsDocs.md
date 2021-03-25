## `○<text>`
Section title

## `;<text>`
Comment

## `%s=<scene>`
Show scene with <scene> sceneID

## `%timer`
 - `%timer.start` - start timer
 - `%timer.wait=<ms>` - sleep until timer hits <ms> milliseconds

## `%face=<id>,<name>`
Show face of <id> ID and <name> name. Name is in japanese. Don't know which ID letter is selected

## `%facecloseAll`
Close all faces

## `%sound.play=<id>`
Play sound <id>

## `%selSpeed`
 - `%selSpeed.Scroll.Set=<width>,<height>,<horizontal_speed>,<vertical_speed>,<start_width>,<start_height>` - Set scrolling scene
 - `%selSpeed.Scroll` - Start scrolling
 - `%selSpeed.DeleteAll` - Delete scrolling object
 - `%selSpeed.Scroll.Number=<id>` - Set scene id for scrolling. (I think it's hardcoded, as in id=0 is s=C004)

# Misc

## Scrolling
```
; First scrolling scenes - Shinji (horizontally, left-to-right), Asuka (horizontally, right-to-left), PenPen (vertically, top-to-bottom)
%sound.play=004-006
%timer.start

%selSpeed.Scroll.Timer=4
%selSpeed.Scroll.Number=0
; Set=<width>,<height>,<horizontal_speed>,<vertical_speed>,<start_width>,<start_height>
%selSpeed.Scroll.Set=740,400,40,0,0,0
%selSpeed.Scroll

%selSpeed.Scroll.Number=1
%selSpeed.Scroll.Set=740,400,-40,0,329,0

%timer.wait=68
%selSpeed.Scroll
%selSpeed.Scroll.Number=2
%selSpeed.Scroll.Set=740,400,0,40,0,0

%timer.wait=133
%selSpeed.Scroll

%timer.wait=282
%selSpeed.DeleteAll
```
