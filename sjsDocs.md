## `○<text>`
Section title

## `;<text>`
Comment

## `＃<file>`
Execute file <file>
 
## `＊<name>`
Function (goto point) definition

## `%s=<scene>`
Show scene with <scene> sceneID
 
## `%system`
Show system options screen (Save files, screen resolution, exit)

## `%select`
 - `%cmnd.delete` - I don't know, but execute before spawning menu
 - `%select.clear` - Clear menu options
 - `%select.set=<function_to_call>,<show_name>` - Add new entry in menu, after click goto function
 - `%select.wait` - Wait for user input (click), then close

## `%timer`
 - `%timer.start` - start timer
 - `%timer.wait=<ms>` - sleep until timer hits <ms> milliseconds

## `%face`
 - `%face=<id>,<name>` - Show face of <id> ID and <name> name. Name is in japanese. Don't know which ID letter is selected
 - `%face=<id>,<name>,<unknown>` - Same as `%face=<id>,<name>`
 - `%facecloseAll` - Close all faces
 - `%faceclose=<id>` - Close face of id <id>

## `%sound.play=<id>`
Play sound <id>

## `%selSpeed`
 - `%selSpeed.Scroll.Set=<width>,<height>,<horizontal_speed>,<vertical_speed>,<start_width>,<start_height>` - Set scrolling scene
 - `%selSpeed.Scroll` - Start scrolling current object
 - `%selSpeed.DeleteAll` - Delete all scrolling objects
 - `%selSpeed.Scroll.Number=<id>` - Set scene id for scrolling. Id is indexed from 0 by `.Create`
 - `%selSpeed.Create=<id>` - Create object for scrolling

# Misc

## Scrolling
```
; First scrolling scenes - Shinji (horizontally, left-to-right), Asuka (horizontally, right-to-left), PenPen (vertically, top-to-bottom)

%selSpeed.Create=C004
%selSpeed.Create=C005
%selSpeed.Create=C006

; Static c001 and c002 scenes here

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

## Shaking
```
; Asuka kick scene
%selSpeed.Create=C009B
%qblack

○ミサトのマンション・ベランダ（夜）

;アスカの蹴りがシンジの顔面に決まる。
;ぶれ設定

%selSpeed.Bure.Timer=3
%selSpeed.Bure.Number=0
%selSpeed.Bure.Set=740,400,0,30
%selSpeed.Bure.Mode=0
%selSpeed.Bure.Count=60

%timer.wait=238
%face=4,アスカ
アスカ「$a11010 Vielen Dank!」1

%sound.play=009b
%timer.start

%selSpeed.Bure
%selSpeed.Draw
%faceclose=4
```

## Menu
```
; From AI00.sjs - First menu

＊始まり始まり

;----------------
;0=General MIDI Reset.
%midi.play=0

☆初めのセーブポイント

%cmnd.delete

%select.clear
%select.set=ゲームを始める,Startgame
%select.set=システム,Options
%select.wait

＊システム
%system
goto 始まり始まり

＊ゲームを始める

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;＃test001.txt

＃ava011.txt
```
