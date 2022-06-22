import util
import MessageDB
from Message import Message
messagerepository = MessageDB.repository


from BookmarkRegistered import BookmarkRegistered

def wheneverBookmarkRegistered_SendRegisterBookmark(data):
    event = BookmarkRegistered()
    event = util.AutoBinding(data, event)
    
    message = Message()
    messagerepository.save(message)
    
from BookmarkCanceled import BookmarkCanceled

def wheneverBookmarkCanceled_SendCancelBookmark(data):
    event = BookmarkCanceled()
    event = util.AutoBinding(data, event)
    
    message = Message()
    messagerepository.save(message)
    

