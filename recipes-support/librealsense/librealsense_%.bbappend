BACKEND = "LIBUVC"

do_install_append () {
	install -d "${D}${sysconfdir}/modprobe.d"
	install -m 0644 ${S}/config/uvc.conf ${D}${sysconfdir}/modprobe.d
}

FILES_${PN} += "${sysconfdir}/modprobe.d/*"
