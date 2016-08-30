require librealsense.inc

SRC_URI = "git://github.com/IntelRealSense/librealsense.git;branch=development"
SRCREV = "6526c0efb90be1557b01fcf691a6d751d3608147"

PR = "r0"

S = "${WORKDIR}/git"

FILES_${PN}-examples += "\
	${EXAMPLES_DIR}/cpp-callback \
	${EXAMPLES_DIR}/cpp-motion-module \
"
FILES_${PN}-graphical-examples += "\
	${EXAMPLES_DIR}/cpp-callback-2 \
	${EXAMPLES_DIR}/cpp-stride \
"
