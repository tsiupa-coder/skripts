'''
        /\\\\            ┌--┐                    /\\\\              ┌------------┐              /\\\\        /\\\\          ┌-┐
       /  \\\\           |  |                   /  \\\\             |  ┌------┐  |             /  \\\\      /  \\\\         | |
      /    \\\\          |  |                  /    \\\\            |  |      |  |            /    \\\\    /    \\\\        | |
     /      \\\\         |  |                 /      \\\\           |  |------┘  |           /      \\\\  /      \\\\       | |
    /        \\\\        |  |                /        \\\\          |  |---------┘          /        \\\\/        \\\\      | |
   /----------\\\\       |  |               /----------\\\\         |  |    \\\\           /                       \\\\     | |
  /            \\\\      |  |              /            \\\\        |  |     \\\\         /                         \\\\    └-┘
 /              \\\\     |  └--------┐    /              \\\\       |  |      \\\\       /                           \\\\   ┌-┐
/                \\\\    └-----------┘   /                \\\\      └--┘       \\\\     /                             \\\\  └-┘ 
'''

import java.time.LocalTime
import java.time.format.DateTimeFormatter
if(args.size() < 2) throw new IllegalArgumentException("Please include task name and deadline time")
def task = args[0];
def deadline = args[1]
if(task == null || deadline == null) throw new IllegalArgumentException("Please include task name and deadline time")
def date = Date.parse("HH:mm", deadline)
def alarmTime = date.toOffsetDateTime().atZoneSameInstant(TimeZone.getDefault().toZoneId()).toLocalDateTime()
def duration = alarmTime.toLocalTime().toSecondOfDay() - LocalTime.now().toSecondOfDay()
def totalSteps = 100
def stepMil = duration * 10
def stepSec = duration / totalSteps
def currentStep = 1;
while (duration > 0) {
    print "\r[${"=".multiply(currentStep)}${" ".multiply(totalSteps - currentStep)}] done $currentStep% of $task"
    duration -= stepSec
    currentStep += 1
    sleep(stepMil)
}
println("\u001B[2J")
def alarmMessage = "It's now ${alarmTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"))}"
println alarmMessage