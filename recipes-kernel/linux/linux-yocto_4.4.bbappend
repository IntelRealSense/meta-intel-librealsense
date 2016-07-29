FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://uvc.cfg"
SRC_URI += "file://RealSense_Camera_Support_${PN}_4.4.patch"
SRC_URI += "file://RW10-pixel-format-detect.patch"
