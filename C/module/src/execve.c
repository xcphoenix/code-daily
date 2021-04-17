/**
 * Created by xuanc on 2021/2/2.
 */

#include <linux/fs.h>
#include <linux/sched.h>
#include <uapi/linux/ptrace.h>

struct exec_data {
    int pid;
    char[256] name;
};
BPF_PERF_OUTPUT(events);

int syscall__execve(struct pt_regs *ctx, const char __user *filename,
                    const char __user *const __user *__argv,
                    const char __user *const __user *__envp) {
    struct exec_data data = {};

    int len = 0;
    while (filename[len] != '\0') {
        len++;
    }

    data.pid = (u32)bpf_get_current_pid_tgid();
    bpf_probe_read_kernel_str((void *)&(data.name), len, (void *)filename);

    events.perf_submit(ctx, &data, sizeof(data));
    return 0;
}
