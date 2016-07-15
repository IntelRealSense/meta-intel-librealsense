require librealsense.inc

SRC_URI = "git://github.com/IntelRealSense/librealsense.git;branch=development"
SRCREV = "7752bbe1b9dab586d7ada93eb2dfbb2632ba01d2"

PR = "r0"

S = "${WORKDIR}/git"

FILES_${PN}-examples += "\
	${EXAMPLES_DIR}/cpp-callback \
	${EXAMPLES_DIR}/cpp-motion-module \
"
FILES_${PN}-graphical-examples += "\
	${EXAMPLES_DIR}/cpp-callback-2 \
	${EXAMPLES_DIR}/cpp-multi-threading-1 \
	${EXAMPLES_DIR}/cpp-multi-threading-2 \
	${EXAMPLES_DIR}/cpp-stride \
"
