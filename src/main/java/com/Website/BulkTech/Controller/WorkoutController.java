package com.Website.BulkTech.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class WorkoutController {

    @GetMapping("/workout/day/{day}")
    public String workoutByDay(@PathVariable int day, Model model) {

        Map<Integer, List<String>> workoutPlan = new HashMap<>();

        workoutPlan.put(1, List.of(
                "Cardio",
                "Combo Raise",
                "Assistant Dips",
                "Assistant Pull Ups",
                "Shoulder Press",
                "Step Up",
                "Ab Curl",
                "Squats",
                "Butt Blaster",
                "Stretching"
        ));

        workoutPlan.put(2, List.of(
                "Cardio",
                "Free Squat",
                "Sit Up Knee Raise",
                "Lunges",
                "One Arm Rowing",
                "Shoulder Shrugs",
                "Ab-Curl",
                "Reverse Curl",
                "Cardio",
                "Iron Man"
        ));

        workoutPlan.put(3, List.of(
                "Cardio",
                "Free Squat",
                "Modified PushUps",
                "Dead Lift",
                "Leg Curl",
                "Leg Press",
                "Ab-Crunch",
                "Reverse Curl",
                "Side Bends",
                "Hyper Extension"
        ));

        workoutPlan.put(4, List.of(
                "Cardio",
                "Free Squat",
                "Lunges",
                "Leg Extension",
                "Side Bends",
                "Ab-Curl",
                "Twist Curl",
                "Side Bends",
                "Hyper Extension"
        ));

        workoutPlan.put(5, List.of(
                "Cardio",
                "Chest Press",
                "Lat Pull Down",
                "Seated Row",
                "Side Lateral Raise",
                "Ab-Crunch",
                "Leg Raise",
                "Plank",
                "Stretching"
        ));

        workoutPlan.put(6, List.of(
                "Cardio",
                "Biceps Curl",
                "Triceps Push Down",
                "Hammer Curl",
                "Over Head Triceps Extension",
                "Front Raise",
                "Russian Twist",
                "Mountain Climbers",
                "Cycling"
        ));
        List<String> exercises = workoutPlan.get(day);

        model.addAttribute("day", day);
        model.addAttribute("exercises", exercises);

        return "workout";
    }
}
