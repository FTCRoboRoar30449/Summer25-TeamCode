package pedroPathing.examples;

import com.pedropathing.follower.Follower;
import com.pedropathing.localization.Pose;
import com.pedropathing.pathgen.BezierCurve;
import com.pedropathing.pathgen.BezierLine;
import com.pedropathing.pathgen.Path;
import com.pedropathing.pathgen.PathChain;
import com.pedropathing.pathgen.Point;
import com.pedropathing.util.Timer;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import pedroPathing.constants.FConstants;
import pedroPathing.constants.LConstants;

private final Pose startPose = new Pose(8, 80, Math.toRadians(0));  // Starting/idle position
private final Pose dropPose = new Pose(20, 120, Math.toRadians(-45)); // Scoring/high basket position

private final Pose preStaged1Pose = new Pose(30, 120, Math.toRadians(0)); // First Pre-staged sample pickup
private final Pose preStaged2Pose = new Pose(30, 130, Math.toRadians(0)); // Second Pre-staged sample pickup
private final Pose preStaged3Pose = new Pose(30, 130, Math.toRadians(45)); // Third Pre-staged sample pickup
private final Pose subPose = new Pose(71, 105, Math.toRadians(-90)); // sub pickup/position
private final Pose endPose = new Pose(70, 100, Math.toRadians(90));    // Endgame position - low rung

