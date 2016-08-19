require librealsense.inc

SRC_URI = "git://github.com/IntelRealSense/librealsense.git;branch=development"
SRCREV = "6e9b2ac380bd7057d4797afe8e25abf13ef3a931"

PR = "r0"

S = "${WORKDIR}/git"

FILES_${PN}-examples += "\
	${EXAMPLES_DIR}/cpp-callback \
	${EXAMPLES_DIR}/cpp-mm-fw-update \
	${EXAMPLES_DIR}/cpp-motion-module \
"
FILES_${PN}-graphical-examples += "\
	${EXAMPLES_DIR}/cpp-callback-2 \
	${EXAMPLES_DIR}/cpp-stride \
"
