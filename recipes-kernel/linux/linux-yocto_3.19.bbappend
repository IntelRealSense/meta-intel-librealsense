FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://uvc.cfg"
SRC_URI += "file://RealSense_Camera_Support_${PN}_3.19.patch"
SRC_URI += "file://UVC_Remove_extra_commit_on_resume_${PN}_3.19.patch"
